from django.urls import path
from . import views	
                    
urlpatterns = [
    path('',views.index),
    path('shows', views.show),
    path('shows/new',views.new_show),
    path('add',views.add_show),
    path('shows/<x>',views.display),
    path('shows/<x>/edit',views.edit),
    path('edit/<x>',views.update),
    path('shows/<x>/delete',views.delete)
]