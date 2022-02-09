import re
from django.shortcuts import redirect, render

def index(request):
    if not 'count' in request.session:
        request.session['count']=0
    else:
        request.session['count']+=1
    return render(request,'counter.html',)

def remove(request):
    del request.session['count']
    return redirect('/')

def add(request):
    request.session['count']+=1
    return redirect('/')

def increment(request):
    request.session['x']=int(request.POST['increment'])
    request.session['count']+= request.session['x']-1
    return redirect('/')
