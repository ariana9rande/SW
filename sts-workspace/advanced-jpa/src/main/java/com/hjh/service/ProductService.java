package com.hjh.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hjh.entity.Product;
import com.hjh.repository.ProductRepository;

// 예제 6.22
@Service
public class ProductService
{
	ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository)
	{
		this.productRepository = productRepository;
	}
	
	public List<Product> getProductList()
	{
		List<Product> productList = productRepository.findAll();
		return productList;
	}
	
	public Product getProduct(Long id)
	{
		Optional<Product> optionalProduct = productRepository.findById(id);
		Product product = null;
		if(optionalProduct.isPresent())
		{
			product = optionalProduct.get();
		}
		return product;
	}

	public void saveProduct(Product product)
	{
		Product newProduct = new Product();
		newProduct.setName(product.getName());
		newProduct.setPrice(product.getPrice());
		newProduct.setStock(product.getStock());
		newProduct.setCreatedDate(LocalDateTime.now());
		newProduct.setUpdatedDate(LocalDateTime.now());
		
		productRepository.save(newProduct); 
	}

	public Product changeProductName(Long number, String name) throws Exception
	{
		Product changedProduct = productDao.updateProductName(number, name);

		Product product = new Product();
		product.setId(changedProduct.getId());
		product.setName(changedProduct.getName());
		product.setPrice(changedProduct.getPrice());
		product.setStock(changedProduct.getStock());

		return product;
	}

	public void deleteProduct(Long number) throws Exception
	{
		productDao.deleteProduct(number);
	}
}
