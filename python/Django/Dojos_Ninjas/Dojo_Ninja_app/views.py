from unicodedata import name
from django.shortcuts import redirect, render
from .models import Dojo,Ninja

def index(request):
    Dojo.objects.create(name=request.POST['name'], city=request.POST['city'],state=request.POST['state'])
    return redirect('/')

def ninja(request):
    Ninja.objects.create(first_name=request.POST['first_name'],last_name=request.POST['last_name'],
    dojo=Dojo.objects.get(id=request.POST['x']))
    return redirect('/')

def show(request):
    context={
        "Dojos":Dojo.objects.all()
    }
    return render(request,'dojo_ninja.html',context)


