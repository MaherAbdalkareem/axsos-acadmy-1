from django.shortcuts import redirect, render
from .models import User
def index(request):
    context={
        "all_the_users": User.objects.all()
    }
    return render(request,'user.html',context)

def add(request):
    User.objects.create(first_name=request.POST['name1'],last_name=request.POST['last'],
    email_addres=request.POST['email'],age=request.POST['age'] )
    return redirect('/')

def remove(request):
    x=User.objects.all()
    x.delete()
    return redirect('/')
