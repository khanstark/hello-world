# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from django.contrib.auth.models import User
from django.db import models
import hashlib
import vck
import cv2
import os
from django.db.models.signals import post_save
from django.db.models.signals import pre_save
from django.dispatch import receiver

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

def user_directory_path(instance, filename):
    # file will be uploaded to MEDIA_ROOT/user_<id>/<filename>
    temp_name=str(instance.name)[::-1]
    temp_key=str(instance.passkey)
    s=1
    for i in temp_key:
    	s=s*int(i)
    et=phi(s)
    fin_name=temp_name+str(et)
   
    new_name=hashlib.sha256(str(fin_name)).hexdigest()[:20]
    return '{0}.jpg'.format(new_name)


class sample(models.Model):
	name=models.CharField(max_length=14)
	passkey=models.CharField(max_length=14)
	model_pic = models.FileField(upload_to=user_directory_path)
	
@receiver(post_save, sender=sample)
def handler(sender, instance, **kwargs):
    
    basename, ext = os.path.splitext(instance.model_pic.path)
    basename=str(basename.split('/')[5].split('.')[0])
    ext=str(ext)
    print(basename)
    temp=str(basename)+'#3b5998'
    base2=hashlib.sha256(str(temp)).hexdigest()[:20]
    s1, s2 = vck.splitImage('media/'+str(basename)+str(ext), 'media/'+str(basename) + "e" + str(ext), 'media/'+str(base2)+ "f" + str(ext))
    os.remove(instance.model_pic.path)

class admin_panel(models.Model):
	name1=models.CharField(max_length=14)
	passkey1=models.CharField(max_length=14)
	
# @receiver(post_save, sender=admin_panel)
# def handler(sender, instance, **kwargs):
	