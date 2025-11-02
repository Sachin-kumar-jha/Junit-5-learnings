package com.pizza.jtest;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.pizza.service.PizzaService;
public class PizzaApplicationTesting {
private final Logger logger=Logger.getLogger(PizzaApplicationTesting.class.getName());
	PizzaService application=new PizzaService();
	
	public void pizzaOnDineTest() {
		int actualPrice=application.pizzaPrice(2, 250);
		int expectedPrice=500;
		if(expectedPrice==actualPrice) {
			logger.log(Level.INFO,"Test Pass");
		}else {
			logger.log(Level.WARNING,"Test Fail");
		}
	}
	
public static void main(String[] args) {
	PizzaApplicationTesting application=new PizzaApplicationTesting();
	application.pizzaOnDineTest();
}
}
