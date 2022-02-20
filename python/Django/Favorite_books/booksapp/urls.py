from django.urls import path
from . import views	

urlpatterns = [
    path('books', views.books),
    path('add_book',views.add_book),
    path('add_fav/<x>',views.add_fav),
    path('books/<x>',views.show),
    path('update/<x>',views.update),
    path('delete/<x>',views.delete),
    path('delete/fav/<x>',views.delete_fav)
    
]