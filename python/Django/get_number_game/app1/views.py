from django.shortcuts import render,redirect
import random


def index(request):
    request.session['random']= random.randint(1,100)
    return render(request,'guess.html')

def check(request):
    request.session['num']=request.POST['guess']
    if int(request.session['num']) > request.session['random']:
        request.session["result"] = "high"
        print(request.session['result'])
    elif int(request.session['num']) < request.session['random']:
        request.session["result"] ="low"
        print(request.session['result'])
    else : request.session["result"] = "correct"
    return redirect ('/')
