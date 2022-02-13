from django.urls import path
from . import views	

urlpatterns = [
    path('', views.index),
    path('book',views.add_book),
    path('book/<x>',views.show),
    path('add<num>',views.insert),
    path('author',views.author),
    path('author/<y>',views.display),
    path('plus<number>',views.add)
]