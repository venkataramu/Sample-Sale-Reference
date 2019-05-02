package com.reference.SampleSaleReference.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.reference.SampleSaleReference.entity.Order;
import com.reference.SampleSaleReference.entity.Product;
import com.reference.SampleSaleReference.entity.RegisterUser;
import com.reference.SampleSaleReference.entity.Sales;
import com.reference.SampleSaleReference.repository.OrderRepository;
import com.reference.SampleSaleReference.repository.ProductRepository;
import com.reference.SampleSaleReference.repository.RegisterUserRepository;
import com.reference.SampleSaleReference.repository.SaleRepository;
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
	
	@Autowired
	SaleRepository saleRepository;

	@Override
	@Transactional(isolation=Isolation.SERIALIZABLE, rollbackFor=Exception.class)
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
		Product product = productOptional.get();
		
		Optional<Sales> saleOptional = saleRepository.findById(product.getSaleId());
		if(!saleOptional.isPresent()) {
			throw new ApplicationException("Sale doesn't exists for the Product");
		}
		Sales sale = saleOptional.get();
		if(time.isBefore(sale.getSaleStartTime())) {
			throw new ApplicationException("Product Sale not yet started");
		}
		if(time.isAfter(sale.getSaleEndTime())) {
			throw new ApplicationException("Product sale is ended");
		}
		
		int count = orderRepository.countByCreatedOnBetweenAndSales(sale.getSaleStartTime(), sale.getSaleEndTime(), sale);
		if(count > sale.getAvailableSaleCount()) {
			throw new ApplicationException("Sale is Over .Items are not available");
		}

		RegisterUser registerUser = registerUserRepo.findById(userId).get();
		Order order = new Order(registerUser, product, sale);
		
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
