from django.urls import path     
from . import views
urlpatterns = [
    path('',views.show),
    path('add_dojo', views.index),	   
    path('add_ninja',views.ninja)

]