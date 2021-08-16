package me.loda.spring.helloworld;

import org.springframework.stereotype.Component;

@Component
public class Product implements Outin {

	@Override
	public void getAtribute() {
		// TODO Auto-generated method stub
		System.out.print("product");
		
	}

}
