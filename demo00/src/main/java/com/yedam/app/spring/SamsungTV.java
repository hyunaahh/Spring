package com.yedam.app.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV {
	
	@Autowired
	Speaker speaker;
	
//1. 생성자방식 
	
	//@Autowired
	SamsungTV(Speaker speaker){
		this.speaker = speaker;
	}
	
	
	
//2. Setter 방식  - 기본생성자 명시해준거! (위에있으니까 쓴거임). ( 생성자 함수 없으면 자동생성)	
	SamsungTV(){} 
	
	//@Autowired
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	


	
	
	@Override
	public void on() {
		// TODO Auto-generated method stub
		System.out.println("삼성티비키기");
		speaker.on();
	}

}
