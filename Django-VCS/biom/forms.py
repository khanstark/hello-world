from django import forms
from django.contrib.auth.models import User
from django.contrib.auth.forms import UserCreationForm
from .models import *

class Register(forms.ModelForm):
	# email=forms.EmailField(required=True)
	# name=forms.CharField(required=True)
	# model_pic = forms.ImageField()
	class Meta:
		model=sample
		widgets = {
            'name': forms.TextInput(attrs={'class': 'myfieldclass'}),
            'passkey': forms.PasswordInput(attrs={'class': 'myfieldclass'}),
            'model_pic': forms.FileInput(attrs={'class': 'myfieldclass1'}),
        }
		fields=['name','passkey','model_pic']

	
class Extract(forms.ModelForm):
	class Meta:
		model=admin_panel
		widgets = {
            'name1': forms.TextInput(attrs={'class': 'myfieldclass'}),
            'passkey1': forms.PasswordInput(attrs={'class': 'myfieldclass'})
        }
		fields=['name1','passkey1']
