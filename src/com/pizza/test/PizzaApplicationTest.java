 package com.pizza.test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import com.pizza.service.PizzaService;

@DisplayName("Test For PizzaApplication")
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class PizzaApplicationTest {
	private static final Logger logger = Logger.getLogger(PizzaApplicationTest.class.getName());
 PizzaService application = new PizzaService();
 
    @BeforeAll
    void taskOnce() { 
    	logger.info("@BeforeALl");
    }
    
    @BeforeEach
    void taskAll() {
    	logger.info("@BeforeEach");
    }
 
    @DisplayName("Test for PizzaDine")
	@Test
	@Order(1)
	void pizzaOnDine() {
	int actualPrice= application.pizzaPrice(2, 250);
	int expectedPrice=500;
	assertEquals(expectedPrice,actualPrice);
	}

    @DisplayName("Test for Pizza On offer ☕️")
	@Test
	@Order(2)
	void pizzaOnOffer() {
		int actualPrice=application.pizzaPriceWithOffer(2, 200, 10);
		int expectedPrice=440;
		
		assertEquals(expectedPrice,actualPrice);
	}
	
    @DisplayName("Test for system mode 🙋🏻‍♂️")
	@Test
	@Order(3)
	void partyForDeveloperTeamTest() {
		assumeTrue("Testing".equals(System.getenv("ENV")),()->"Aborting test:not on Developer team");
		int actualPrice=application.pizzaPriceWithOffer(2, 200,10);
		int expectedPrice=440;
		assertEquals(expectedPrice,actualPrice);
		
	}
	
	
    @DisplayName("Test for system Environment")
	@Test
	@Order(4)
	void envTest() {
		assertTrue(System.getenv("ENV").startsWith("D"));
	}
	
    @AfterEach
    void taskAfterEach() { 
    	logger.info("@AfterEach");
    }
    
    
    @AfterAll
    void taskAfterOnce() {
    	logger.info("@AfterAll");
    }
	
}