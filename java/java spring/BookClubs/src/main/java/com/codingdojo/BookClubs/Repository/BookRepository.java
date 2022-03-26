package com.codingdojo.BookClubs.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.BookClubs.model.Book;
import com.codingdojo.BookClubs.model.User;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findAll();
	List<Book> findByUsersNotContains(User user);
}
