package com.codingdojo.BookClubs.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.BookClubs.Repository.BookRepository;
import com.codingdojo.BookClubs.model.Book;
import com.codingdojo.BookClubs.model.User;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	public Book findBook(Long id) {
		Optional<Book> book= bookRepository.findById(id);
		if(book.isPresent()) {
			return book.get();
		}
		else {
			return null;
		}
	}
	public List<Book> userBook(User user){
		return bookRepository.findByUsersNotContains(user);
	}
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
