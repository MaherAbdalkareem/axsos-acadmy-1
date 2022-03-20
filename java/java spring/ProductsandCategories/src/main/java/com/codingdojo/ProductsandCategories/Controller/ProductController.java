package com.codingdojo.ProductsandCategories.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ProductsandCategories.Service.CategoryService;
import com.codingdojo.ProductsandCategories.Service.ProductService;
import com.codingdojo.ProductsandCategories.models.Category;
import com.codingdojo.ProductsandCategories.models.Product;

@Controller
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product")Product product) {
		return "newproduct.jsp";
	}
	@RequestMapping(value = "/new/product",method = RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product")Product product,BindingResult result) {
		productService.createProduct(product);
		return "redirect:/products/new";
	}
	@RequestMapping("/products/{id}")
	public String myProduct(@PathVariable("id")Long id,Model model) {
		Product product = productService.findProduct(id);
		List<Category> categoryBelong=productService.findBelongCategory(product);
		List<Category> categoryNotBelong=productService.findNotBelongCategory(product);
		model.addAttribute("product", product);
		model.addAttribute("categoryNotBelong", categoryNotBelong);
		model.addAttribute("categoryBelong", categoryBelong);
		return "product.jsp";
	}
	@RequestMapping("/new/category/{id}")
	public String addCategory(@RequestParam(value = "categories")Category category,@PathVariable("id")Long id) {
		 productService.addCategory(category, id);
		 return "redirect:/products/"+ id;
	}
}
