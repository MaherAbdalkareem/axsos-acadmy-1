package com.codingdojo.BookClubs.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.BookClubs.Service.BookService;
import com.codingdojo.BookClubs.Service.UserService;
import com.codingdojo.BookClubs.model.Book;
import com.codingdojo.BookClubs.model.User;

@Controller
public class BookController {
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public String home(Model model,HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Optional<User> possibleUser = userService.findUser(userId);
		if(!possibleUser.isPresent()) {
			return "redirect:/";
		}
		User thisUser = possibleUser.get();
		List<Book> books=bookService.allBooks();
		model.addAttribute("thisUser", thisUser);
		model.addAttribute("books", books);
		return "welcome.jsp";
	}
	@GetMapping("/books/new")
	public String newBook( @ModelAttribute("newBook")Book book) {
		return "newbook.jsp";
	}
	@PostMapping("/new/book")
	public String createBook(@Valid @ModelAttribute("newBook")Book book,BindingResult result,HttpSession session) {
		Long userId= (Long) session.getAttribute("user_id");
		Optional<User> user= userService.findUser(userId);
		if(!user.isPresent()) {
			return "redirect:/";
		}
		book.setUser(user.get());
		bookService.saveBook(book);
		return "redirect:/books";
	}
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id")Long id,Model model,HttpSession session) {
		Book book = bookService.findBook(id);
		Long userId= (Long) session.getAttribute("user_id");
		Optional<User> user= userService.findUser(userId);
		User user1=user.get();
		model.addAttribute("book", book);
		model.addAttribute("user", user1);
		return "showbook.jsp";
	}
	@GetMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id")Long id,Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("editBook", book);
		return "editbook.jsp";
	}
	@PostMapping("/edit/{id}")
	public String myBook(@Valid @ModelAttribute("editBook")Book book,BindingResult result,@PathVariable("id")Long id) {
		Book book1 = bookService.findBook(id);
		book1.setAuthor(book.getAuthor());
		book1.setMyThoughts(book.getMyThoughts());
		book1.setTitle(book.getTitle());
		bookService.saveBook(book1);
		return "redirect:/books";
	}
	@GetMapping("/bookmarket")
	public String markeBook(HttpSession session,Model model) {
		Long userId= (Long) session.getAttribute("user_id");
		Optional<User> user=userService.findUser(userId);
		if(user.isPresent()) {
		List<Book> myBooks=bookService.userBook(user.get());
		model.addAttribute("myBooks",myBooks);
		model.addAttribute("user", user.get());
		return "bookmarket.jsp";
		}
		else {
			return null;
		}
	}
	@GetMapping("/borrow/{id}")
	public String borrowBook(@PathVariable("id")Long id,HttpSession session) {
		Long userId= (Long) session.getAttribute("user_id");
		Optional<User> user=userService.findUser(userId);
		if(user.isPresent()) {
		User user1=user.get();
		Book book=bookService.findBook(id);
		user1.getBorrowedBooks().add(book);
		userService.saveUser(user1);
		return "redirect:/bookmarket";
		}
		else {return null;}
	}
	@GetMapping("/return/{id}")
	public String returnBook(@PathVariable("id")Long id,HttpSession session) {
		Long userId= (Long) session.getAttribute("user_id");
		Optional<User> user=userService.findUser(userId);
		if(user.isPresent()) {
		User user1=user.get();
		Book book=bookService.findBook(id);
		user1.getBorrowedBooks().remove(book);
		userService.saveUser(user1);
		return "redirect:/bookmarket";
		}
		else {return null;}
	}
	@GetMapping("/books/{id}/delete")
	public String deleteBook(@PathVariable("id")Long id) {
		bookService.deleteBook(id);
		return "redirect:/bookmarket";
	}
}
