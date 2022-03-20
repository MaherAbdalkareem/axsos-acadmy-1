package com.codingdojo.ProductsandCategories.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ProductsandCategories.models.Category;
import com.codingdojo.ProductsandCategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
List<Category> findAllByProducts(Product product);
List<Category> findByProductsNotContains(Product product);
}
