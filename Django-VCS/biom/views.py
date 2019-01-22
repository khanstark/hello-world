# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render,redirect
from django.http import HttpResponse
from PIL import Image
from .forms import Register,Extract
from django.contrib.auth.forms import UserCreationForm
import cv2
import hashlib
import vck
import os
import Tkinter
from PIL import Image
from PIL import ImageDraw
from PIL import ImageTk
def reg(request):
	if request.method =='POST':
		form=Register(request.POST,request.FILES)
		if(form.is_valid()):
			form.save()
			return redirect('/biom/')
	else:
		form=Register()
	return render(request,'../templates/index.html',{'form':form})

def phi(n):
	result = n
	p = 2
	while(p * p<= n) :
		if (n % p == 0) :
			while (n % p == 0) :
				n = n // p
			result = result * (1.0 - (1.0 / (float) (p)))
		p = p + 1
	if (n > 1) :
		result = result * (1.0 - (1.0 / (float)(n)))
	return (int)(result)

def admin(request):
	if request.method =='POST':
		form=Extract(request.POST)
		if(form.is_valid()):
			form.save()
			n=str(form.instance.name1)
			pk=str(form.instance.passkey1)
			temp_name=str(n)[::-1]
			temp_key=str(pk)
			s=1
			for i in temp_key:
				s=s*int(i)
			et=phi(s)
			fin_name=temp_name+str(et)
			digest=hashlib.sha256(fin_name).hexdigest()[:20]
			temp=str(digest)+'#3b5998'
			base2=hashlib.sha256(str(temp)).hexdigest()[:20]
			img1='media/'+str(digest)+'e.jpg'
			img2='media/'+str(base2)+'f.jpg'
			i11=vck.bitmap(str(img1))
			i22=vck.bitmap(str(img2))
			
			# # print('#################333',i1)
			
			# i11=i1.convert('1').tobitmap()
			# i2 = Image.open(img2)
			# # file_out2 = "media/test2.bmp"
			# # i2.save(file_out2)
			# # print(i1)
			# i22=i2.convert('1').tobitmap()
			# print('@@@@@@@@@@@@@@@@@',i11.size())
			result = vck.OR(i11,i22)
			root = Tkinter.Tk()
			quit = Tkinter.Button(root, text="Quit", command=root.quit)
			quit.pack()
			Tkinter.Wm.title(root, "VCK main")
			windowResult = result.view(root)
			root.update()
			root.mainloop()
			# image = Image.open(result)
			# image.show()
			# img11=cv2.imread(img1)
			# img22=cv2.imread(img2)
			# res=vck.XOR(img11,img22)
			# cv2.imshow('res',res)
			# cv2.waitKey(0)
			print('done!')
			return redirect('/biom/admin/')
	else:
		form=Extract()
	return render(request,'../templates/admin_panel.html',{'form':form})