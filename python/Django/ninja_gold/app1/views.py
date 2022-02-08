from itertools import count
from django.shortcuts import redirect, render
import random
from time import gmtime, strftime

from flask import session

def index(request):
    if not 'cont' in request.session:
        request.session['cont']=[]
    if not 'result' in request.session:
        request.session['result']=0
    return render(request,'ninja.html')

def gold(request):
    request.session['time']= strftime("%Y-%m-%d %H:%M %p", gmtime())

    if request.POST['which_form']=='farm' :
        request.session['gold_from_farm']=random.randint(10,20)
        request.session['result']+=request.session['gold_from_farm']
        request.session['cont'].append ( "Earned " +str(request.session['gold_from_farm']) + 'golds from farm! ' + request.session['time'])
    elif request.POST['which_form']=='cave' :
        request.session['gold_from_cave']=random.randint(5,10)
        request.session['result']+=request.session['gold_from_cave']
        request.session['cont'].append('Earned'+ str(request.session['gold_from_cave']) + 'golds from cave!' + request.session['time'])
    elif request.POST['which_form']=='house' :
        request.session['gold_from_house']=random.randint(2,5)
        request.session['result']+=request.session['gold_from_house']
        request.session['cont'].append(' Earned ' + str(request.session['gold_from_house']) + 'golds from house!' + request.session['time'])
    elif request.POST['which_form']=='casino' :
        request.session['gold_from_casino']=random.randint(-50,50)
        request.session['result']+=request.session['gold_from_casino']
        if request.session['gold_from_casino']>0 :
            request.session['cont'].append(' Earned ' + str(request.session['gold_from_casino']) + 'golds from casino!' + request.session['time'])
        elif request.session['gold_from_casino']<0 :
            request.session['cont'].append(' lost ' + str(request.session['gold_from_casino']*-1) + 'golds from casino!' + request.session['time'])
    return redirect('/')

def show(request,gold):
    if gold== "farm":
        request.session['gold_from_farm']=random.randint(10,20)
        request.session['result']+=request.session['gold_from_farm']
        request.session['cont'].append ( "Earned " +str(request.session['gold_from_farm']) + 'golds from farm! ' + request.session['time'])
    elif gold == "cave":
        request.session['gold_from_cave']=random.randint(5,10)
        request.session['result']+=request.session['gold_from_cave']
        request.session['cont'].append('Earned'+ str(request.session['gold_from_cave']) + 'golds from cave!' + request.session['time'])
    elif gold == "house" :
        request.session['gold_from_house']=random.randint(2,5)
        request.session['result']+=request.session['gold_from_house']
        request.session['cont'].append(' Earned ' + str(request.session['gold_from_house']) + 'golds from house!' + request.session['time'])
    elif gold == "casino" :
        request.session['gold_from_casino']=random.randint(-50,50)
        request.session['result']+=request.session['gold_from_casino']
        if request.session['gold_from_casino']>0 :
            request.session['cont'].append(' Earned ' + str(request.session['gold_from_casino']) + 'golds from casino!' + request.session['time'])
        elif request.session['gold_from_casino']<0 :
            request.session['cont'].append(' lost ' + str(request.session['gold_from_casino']*-1) + 'golds from casino!' + request.session['time'])
    return redirect('/')
