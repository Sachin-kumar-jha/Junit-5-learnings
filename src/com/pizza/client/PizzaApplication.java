package com.pizza.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.pizza.service.PizzaService;

public class PizzaApplication {
	 private final static Logger logger=Logger.getLogger(PizzaApplication.class.getName());
	public static void main(String[] args) {
 PizzaService application = new PizzaService();
 int total =application.pizzaPrice(2, 250);
 logger.log(Level.INFO,"Total"+" "+total);
	}

}
