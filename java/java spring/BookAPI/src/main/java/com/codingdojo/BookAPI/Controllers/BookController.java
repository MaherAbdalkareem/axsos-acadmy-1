package com.codingdojo.BookAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.BookAPI.models.Book;
import com.codingdojo.BookAPI.service.BookServices;

@Controller
public class BookController {
	@Autowired
	BookServices bookServices;
	@RequestMapping("/book/{id}")
	public String show(Model model,@PathVariable("id")Long id) {
		Book book = bookServices.findBook(id);
		model.addAttribute("book", book);
		return "Book.jsp";
	}
	@RequestMapping("/books")
	public String dispaly(Model model) {
		ArrayList<Book> book=bookServices.allBooks();
		model.addAttribute("books", book);
		return "AllBook.jsp";
	}
}
