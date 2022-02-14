
from django.shortcuts import redirect, render
from django.contrib import messages

from .models import Show

def index(request):
    return redirect('/shows')

def show(request):
    context={
        'all_shows':Show.objects.all()
    }
    return render(request,'all_show.html',context)

def new_show(request):
    return render(request,'add_show.html')

def add_show(request):
    errors = Show.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/shows/new')
    else:
        this_show=Show.objects.create(title=request.POST['title'],network=request.POST['network'],
        release_date=request.POST['release_date'],description=request.POST['description'])
        x=this_show.id
        messages.success(request, "Show successfully updated")
        return redirect(f'/shows/{x}')

def display(request,x):
    this_show=Show.objects.get(id=x)
    cont={
        'this_show':this_show
    }
    return render(request,'this_show.html',cont)

def edit(request,x):
    this_show=Show.objects.get(id=x)
    cont1={
        'this_show':this_show
    }
    return render(request,'edit_show.html',cont1)

def update(request,x):
    errors = Show.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect(f'/shows/{x}/edit')
    else:
        this_show=Show.objects.get(id=x)
        this_show.title=request.POST['title']
        this_show.network=request.POST['network']
        this_show.release_date=request.POST['release_date']
        this_show.description=request.POST['description']
        this_show.save()
        messages.success(request, "Show successfully updated")
        return redirect(f'/shows/{x}/edit')

def delete(request,x):
    this_show=Show.objects.get(id=x)
    this_show.delete()
    return redirect('/shows')

