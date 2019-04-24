package com.reference.SampleSaleReference.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reference.SampleSaleReference.entity.Order;
import com.reference.SampleSaleReference.entity.Product;
import com.reference.SampleSaleReference.entity.RegisterUser;
import com.reference.SampleSaleReference.repository.OrderRepository;
import com.reference.SampleSaleReference.repository.ProductRepository;
import com.reference.SampleSaleReference.repository.RegisterUserRepository;
import com.reference.SampleSaleReference.service.PurchaseItemService;
import com.reference.SampleSaleReference.util.ApplicationException;

@Service
public class PurchaseItemServiceImpl implements PurchaseItemService{
	@Autowired
	RegisterUserRepository registerUserRepo;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	@Transactional
	public Order purchaseAnItem(long userId, long productId) {
		LocalDateTime time = LocalDateTime.now();
		Optional<RegisterUser> registerUserOptional = registerUserRepo.findById(userId);
		if(!registerUserOptional.isPresent()) {
			throw new ApplicationException("User doesn't registered for Sale");
		}

		Optional<Product> productOptional = productRepository.findById(productId);
		if(!productOptional.isPresent()) {
			throw new ApplicationException("Product is not in Sale");
		}
		Product product = productRepository.findById(productId).get();
		if(time.isBefore(product.getSaleStartTime())) {
			throw new ApplicationException("Product Sale not yet started");
		}
		if(time.isAfter(product.getSaleEndTime())) {
			throw new ApplicationException("Product sale is ended");
		}
		int count = orderRepository.countByCreatedOnBetweenAndProduct(product.getSaleStartTime(), product.getSaleEndTime(), product);
		if(count > product.getQuantityInSale()) {
			throw new ApplicationException("Sale is Over .Items are not available");
		}

		RegisterUser registerUser = registerUserRepo.findById(userId).get();
		Order order = new Order(registerUser, product);
		return orderRepository.save(order);
	}

	public RegisterUserRepository getRegisterUserRepo() {
		return registerUserRepo;
	}

	public void setRegisterUserRepo(RegisterUserRepository registerUserRepo) {
		this.registerUserRepo = registerUserRepo;
	}

	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public OrderRepository getOrderRepository() {
		return orderRepository;
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	

}
