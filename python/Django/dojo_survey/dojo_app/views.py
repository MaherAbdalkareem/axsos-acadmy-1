from multiprocessing import context
from django.shortcuts import render
from flask import request

def index(request):
    return render(request,'dojo.html')

def show(request):
    name_from_form=request.POST['username']
    location_from_form=request.POST['location']
    language_from_form=request.POST['fav']
    gender_from_form=request.POST['option']
    choose_from_form=request.POST['choose']
    comment_from_form=request.POST['comment']
    context={
        "name": name_from_form,
        "location":location_from_form,
        "language":language_from_form,
        "gender":gender_from_form,
        "choose":choose_from_form,
        "comment":comment_from_form
    }
    return render(request,'show.html',context)
