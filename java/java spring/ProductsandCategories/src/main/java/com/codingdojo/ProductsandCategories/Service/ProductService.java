package com.codingdojo.ProductsandCategories.Service;

import java.util.List;
import java.util.Optional;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.stereotype.Service;

import com.codingdojo.ProductsandCategories.Repository.CategoryRepository;
import com.codingdojo.ProductsandCategories.Repository.ProductRepository;
import com.codingdojo.ProductsandCategories.models.Category;
import com.codingdojo.ProductsandCategories.models.Product;
@Service
public class ProductService {
	private final ProductRepository productRepo;
	private final CategoryRepository categoryRepo;
	public ProductService(ProductRepository productRepo, CategoryRepository categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}
	//create product
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	//find by id 
	public Product findProduct(Long id) {
		Optional<Product> product =  productRepo.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		else {
			return null;
		}
		}
		//find all belongs category
		public List<Category> findBelongCategory(Product product1){
		List<Category> allCategory=	categoryRepo.findAllByProducts(product1);
		return allCategory;
		}
		//find not belong category
		public List<Category> findNotBelongCategory(Product product){
			List<Category> allCategory=categoryRepo.findByProductsNotContains(product);
			return allCategory;
		}
		//add category
		public void addCategory(Category category,Long id) {
			Product product=findProduct(id);
			product.getCategories().add(category);
			 productRepo.save(product);
		}
	}

