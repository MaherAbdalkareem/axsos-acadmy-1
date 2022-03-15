package com.codingdojo.BookAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.BookAPI.BookRepositories.bookRepository;
import com.codingdojo.BookAPI.models.Book;

@Service
public class BookServices {
	
	private final bookRepository bookRepo;

	public BookServices(bookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public ArrayList<Book> allBooks() {
        return bookRepo.findAll();
    }
	
	public List<Book> sameDesc(String desc){
		return bookRepo.findByDescriptionContaining(desc);
	}
	
	public Book addBook(Book newBook) {
		return bookRepo.save(newBook);
	}
	
	public Book findBook(Long id) {
		Optional<Book> myBook = bookRepo.findById(id);
		if(myBook.isPresent()) {
			return myBook.get();
		}
		else {
			return null;
		}
	}
	
	public Book updateBook(Long id,String title, String description, String language, Integer numberOfPages) {
		Book book= findBook(id);
		book.setTitle(title);
		book.setNumberOfPages(numberOfPages);
		book.setDescription(description);
		book.setLanguage(language);
		return bookRepo.save(book);
	}
	
	public void deleteBook(Long id) {
		Book book =findBook(id);
		bookRepo.delete(book);
	}
}
