package com.hjh.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String productList(Model model)
	{
		List<Product> productList = productService.getProductList();
		model.addAttribute("products", productList);
		
		return "list";
	}
}
