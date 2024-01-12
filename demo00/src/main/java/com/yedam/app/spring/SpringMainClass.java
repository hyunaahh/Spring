package com.yedam.app.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		System.out.println("spring방식");
		
		
		ApplicationContext
		ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml"); //container 생성! 를 만들어줄 class
		
		
		//인스턴스 생성 x bean으로! 
		TV tv = (TV)ctx.getBean(TV.class);
		tv.on();
		
		

	}

}
