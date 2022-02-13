from multiprocessing import context
from turtle import title
from django.shortcuts import redirect, render
from .models import Book,Author

def index(request):
    context={
        'Books':Book.objects.all(),
        'Authors':Author.objects.all()
    }
    return render(request,'addbook.html',context)

def add_book(request):
    Book.objects.create(title=request.POST['title'],desc=request.POST['desc'])
    return redirect('/')

def show(request,x):
    book=Book.objects.get(id=x)
    authors=book.authors.all()
    author=Author.objects.exclude(id__in=authors.values_list('id', flat=True))
    con={
        'books':book,
        'authors':authors,
        'author':author,
    }
    return render(request,'book.html',con)

def insert(request,num):
    book=Book.objects.get(id=num)
    this_author=Author.objects.get(id=request.POST['theauthor'])
    book.authors.add(this_author)
    return redirect(f'book/{num}')

def author(request):
    con1={
        'books':Book.objects.all(),
        'authors':Author.objects.all()
    }
    return render(request,'addauthor.html',con1)

def display(request,y):
    author=Author.objects.get(id=y)
    authorbooks=author.books.all()
    books=Book.objects.exclude(id__in=authorbooks.values_list('id', flat=True))
    con3={
        'thisauthor':author,
        'authorbooks':authorbooks,
        'books':books
    }
    return render(request,'author.html',con3)

def add(request,number):
    author=Author.objects.get(id=number)
    this_book=Book.objects.get(id=request.POST['books'])
    author.books.add(this_book)
    return redirect(f'author/{number}')

