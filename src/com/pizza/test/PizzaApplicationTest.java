package com.pizza.test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.pizza.service.PizzaService;

@DisplayName("Test For PizzaApplication")
@TestMethodOrder(OrderAnnotation.class)
public class PizzaApplicationTest {
 PizzaService application = new PizzaService();
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
	
	
}