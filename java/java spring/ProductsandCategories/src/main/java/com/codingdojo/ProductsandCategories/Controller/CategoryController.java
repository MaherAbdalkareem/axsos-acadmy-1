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
public class CategoryController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public CategoryController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	@RequestMapping("/categories/new")
	public String createCategory(@ModelAttribute("category")Category category) {
		return "newcategory.jsp";
	}
	@RequestMapping(value = "/new/category",method = RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("category")Category category,BindingResult result) {
		categoryService.newCategory(category);
		return "redirect:/categories/new";
	}
	@RequestMapping("/categories/{id}")
	public String myProduct(@PathVariable("id")Long id,Model model) {
		Category category = categoryService.findCategory(id);
		List<Product> productBelong=categoryService.findBelongProduct(category);
		List<Product> productNotBelong=categoryService.findNotBelongCategory(category);
		model.addAttribute("category", category);
		model.addAttribute("productBelong", productBelong);
		model.addAttribute("productNotBelong", productNotBelong);
		return "category.jsp";
	}
	@RequestMapping("/new/product/{id}")
	public String addCategory(@RequestParam(value = "products")Product product,@PathVariable("id")Long id) {
		 categoryService.addProduct(product, id);
		 return "redirect:/categories/"+ id;
	}
}
