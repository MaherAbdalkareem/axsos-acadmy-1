package com.codingdojo.BookAPI.BookRepositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.BookAPI.models.Book;

@Repository
public interface bookRepository extends CrudRepository<Book, Long>{
	ArrayList<Book> findAll();
	List<Book> findByDescriptionContaining(String description);
	Long countByTitleContaining(String search);
	boolean existsByLanguage(String search);
}
