from multiprocessing import context
from turtle import title
from django.shortcuts import redirect, render
from django.contrib import messages
from login.models import Book, User


def books(request):
    context={
        'this_user':User.objects.get(id=request.session['id']),
        'users':User.objects.all(),
        'books':Book.objects.all()
    }
    return render(request,'books.html',context)

def add_book(request):
    errors = User.objects.book_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/books')
    else:
        this_book=Book.objects.create(title=request.POST['title'],desc=request.POST['desc'],
        uploaded_by=User.objects.get(id=request.session['id']))
        this_book.liked_books.add(User.objects.get(id=request.session['id']))
        return redirect('/books')

def add_fav(request,x):
    this_book=Book.objects.get(id=x)
    this_user=User.objects.get(id=request.session['id'])
    this_book.liked_books.add(this_user)
    return redirect('/books')

def show(request,x):
    this_book=Book.objects.get(id=x)
    this_user=User.objects.get(id=request.session['id'])
    cont={
        'this_book':this_book,
        'this_user':this_user
    }
    if this_book.uploaded_by_id == this_user.id :
        return render(request,'mybooks.html',cont)
    else:
        return render(request,'favbooks.html',cont)

def update(request,x):
    this_book=Book.objects.get(id=x)
    this_book.title=request.POST['title']
    this_book.desc=request.POST['desc']
    this_book.save()
    return redirect(f'/books/{x}')

def delete(request,x):
    this_book=Book.objects.get(id=x)
    this_book.delete()
    return redirect('/books')

def delete_fav(request,x):
    this_book=Book.objects.get(id=x)
    this_user=User.objects.get(id=request.session['id'])
    this_book.liked_books.remove(this_user)
    return redirect(f'/books/{x}')