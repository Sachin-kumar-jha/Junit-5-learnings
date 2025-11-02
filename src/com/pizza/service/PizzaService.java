package com.pizza.service;

public class PizzaService {
	
	public int pizzaPrice(int quantity,int price) {
		return quantity*price;
	}
	
	public int pizzaPriceWithOffer(int quantity,int price,int offer) {
		int total = quantity*price;
		return total+ (total*offer)/100;
	}
}
