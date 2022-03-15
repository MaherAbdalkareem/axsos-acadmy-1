package com.codingdojo.BookAPI.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.BookAPI.models.Book;
import com.codingdojo.BookAPI.service.BookServices;

@RestController
public class Controller {
	private final BookServices bookServices;
	
	public Controller(BookServices bookServices) {
		this.bookServices = bookServices;
	}

	@RequestMapping("/api/book")
	public List<Book> allBppk(){
		return bookServices.allBooks();
	}
	
	@RequestMapping(value = "/api/book" , method = RequestMethod.POST)
	public Book addBook(@RequestParam(value = "title")String title,@RequestParam(value = "desc")String desc,
			@RequestParam(value = "language")String language,@RequestParam(value = "number")Integer number) {
		Book book= new Book(title,desc,language,number);
		return bookServices.addBook(book);
	}
	
	@RequestMapping("/api/book/{id}")
	public Book myBook(@PathVariable("id") Long id) {
		return bookServices.findBook(id);	}
	
	@RequestMapping(value = "/api/book/{id}" , method = RequestMethod.POST)
	public Book addBook(@PathVariable("id")Long id,@RequestParam(value = "title")String title,@RequestParam(value = "desc")String desc,
			@RequestParam(value = "language")String language,@RequestParam(value = "number")Integer number) {
		
		Book book= bookServices.updateBook(id, title, desc, language, number);
		return book;
	}
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookServices.deleteBook(id);
    }
}
