package com.codingdojo.ProductsandCategories.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ProductsandCategories.Repository.CategoryRepository;
import com.codingdojo.ProductsandCategories.Repository.ProductRepository;
import com.codingdojo.ProductsandCategories.models.Category;
import com.codingdojo.ProductsandCategories.models.Product;
@Service
public class CategoryService {
	private final ProductRepository productRepo;
	private final CategoryRepository categoryRepo;
	public CategoryService(ProductRepository productRepo, CategoryRepository categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}
	//create category
	public Category newCategory(Category category) {
		return  categoryRepo.save(category);
	}
	//find by id 
		public Category findCategory(Long id) {
			Optional<Category> category =  categoryRepo.findById(id);
			if (category.isPresent()) {
				return category.get();
			}
			else {
				return null;
			}
			}
			//find all belongs Product
			public List<Product> findBelongProduct(Category category){
			List<Product> allProduct=productRepo.findAllBycategories(category);
			return allProduct;
			}
			//find not belong Product
			public List<Product> findNotBelongCategory(Category category){
				List<Product> allProduct=productRepo.findBycategoriesNotContains(category);
				return allProduct;
			}
			//add Product
			public void addProduct(Product product,Long id) {
				Category category=findCategory(id);
				category.getProducts().add(product);
				categoryRepo.save(category);
			}
}
