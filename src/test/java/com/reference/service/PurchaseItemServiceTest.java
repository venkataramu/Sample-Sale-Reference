package com.reference.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.reference.SampleSaleReference.entity.Product;
import com.reference.SampleSaleReference.entity.RegisterUser;
import com.reference.SampleSaleReference.entity.Sales;
import com.reference.SampleSaleReference.repository.OrderRepository;
import com.reference.SampleSaleReference.repository.ProductRepository;
import com.reference.SampleSaleReference.repository.RegisterUserRepository;
import com.reference.SampleSaleReference.service.impl.PurchaseItemServiceImpl;
import com.reference.SampleSaleReference.util.ApplicationException;

public class PurchaseItemServiceTest {
	
	@Mock
	RegisterUserRepository  registerUserRepo;
	
	@Mock
	OrderRepository orderRepository;
	
	@Mock 
	ProductRepository productRepository;
	
	PurchaseItemServiceImpl service;
	
	long userId = 12345;
	
	long productId =123;
	
	long saleId = 2222;
	
	Product productItem;
	
	Sales sale;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		service = new PurchaseItemServiceImpl();
		service.setRegisterUserRepo(registerUserRepo);
		service.setProductRepository(productRepository);
		service.setOrderRepository(orderRepository);
		
	}
	
	@Test(expected = ApplicationException.class)
	public void testExecuteCheckUserUnregistered() {
		Mockito.when(registerUserRepo.findById(userId)).thenReturn(Optional.empty());
		service.purchaseAnItem(userId, productId);
	}
	
	@Test(expected = ApplicationException.class)
	public void testExecuteCheckBeforeSaleStart() {
		productItem = new Product(productId, "xyz", LocalDateTime.now(), saleId);
		Optional<Product> product = Optional.of(productItem);
		Mockito.when(registerUserRepo.findById(userId)).thenReturn(Optional.of(new RegisterUser(userId, saleId)));
		Mockito.when(productRepository.findById(productId)).thenReturn(product);
		service.purchaseAnItem(userId, productId);
	}
	
	@Test(expected = ApplicationException.class)
	public void testExecuteCheckAfterSaleEnd() {
		productItem = new Product(productId, "xyz", LocalDateTime.now(), saleId);
		Optional<Product> product = Optional.of(productItem);
		Mockito.when(registerUserRepo.findById(userId)).thenReturn(Optional.of(new RegisterUser(userId, saleId)));
		Mockito.when(productRepository.findById(productId)).thenReturn(product);
		service.purchaseAnItem(userId, productId);
	}
	
	
	@Test(expected = ApplicationException.class)
	public void testExecuteCheckItemNotInSale() {
		Optional<Product> item = Optional.empty();
		Mockito.when(registerUserRepo.findById(userId)).thenReturn(Optional.of(new RegisterUser(userId, saleId)));
		Mockito.when(productRepository.findById(productId)).thenReturn(item);
		service.purchaseAnItem(userId, productId);
	}
	
	
	/*
	 * @Test public void executeSuccessfull() { productItem = new Product(productId,
	 * "xyz", LocalDateTime.now(), saleId);
	 * 
	 * sale = new Sales(saleId, "xyz",
	 * LocalDateTime.parse("2015-04-15T15:52:40.410"),
	 * LocalDateTime.parse("2019-12-17T15:52:40.410")); Optional<Product> item =
	 * Optional.of(productItem);
	 * Mockito.when(registerUserRepo.findById(userId)).thenReturn(Optional.of(new
	 * RegisterUser(userId)));
	 * Mockito.when(productRepository.findById(productId)).thenReturn(item);
	 * Mockito.when(orderRepository.countByCreatedOnBetweenAndProduct(item.get().
	 * getSaleStartTime(),item.get().getSaleEndTime(),item.get())).thenReturn(1);
	 * service.purchaseAnItem(userId, productId);
	 * assertTrue(productItem.getQuantityInSale()>1); }
	 */

}
