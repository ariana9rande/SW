package com.hjh.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hjh.entity.Product;
import com.hjh.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController
{

	private final ProductService productService;

	public ProductController(ProductService productService)
	{
		this.productService = productService;
	}
	
	@GetMapping({"/list", "/"})
	public String productListPage(Model model)
	{
		List<Product> productList = productService.getProductList();
		model.addAttribute("products", productList);
		
		return "list";
	}
	
	@GetMapping("/add")
	public String productAddPage()
	{
		return "add_form";
	}
	
	@PostMapping("/add")
	public String productAdd(@RequestParam(value="name") String name, Principal principal)
	{
		productService.saveProduct(null);
		
		return "redirect:list";
	}
}
