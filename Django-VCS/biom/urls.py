from django.conf.urls import url
from . import views

urlpatterns=[
	url(r'^$',views.reg,name='register'),
	url(r'^admin/',views.admin,name='admin_panel'),
]
