package com.codingdojo.ProductsandCategories.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ProductsandCategories.models.Category;
import com.codingdojo.ProductsandCategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAllBycategories(Category category);
	List<Product> findBycategoriesNotContains(Category category);
}
