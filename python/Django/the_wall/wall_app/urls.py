from django.urls import path
from . import views	

urlpatterns = [
    path('', views.index),
    path('register',views.register),
    path('wall',views.wall),
    path('login',views.login),
    path('add_post',views.add_post),
    path('add_comment',views.add_comment),
    path('delete',views.delete)
]