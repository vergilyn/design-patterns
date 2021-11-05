package com.vergilyn.examples.pattern.state.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.statemachine.StateMachine;

public class SpringStateMainTest{
	public static void main(String[] args) {
		SpringApplication.run(SpringStateMainTest.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan(SpringStateMainTest.class.getPackage().getName());
		context.refresh();

		StateMachine<StateEnum, EventEnum> stateMachine = context.getBean(StateMachine.class);

		// FIXME 2021-11-05 替换过时的方法
		stateMachine.start();
		stateMachine.sendEvent(EventEnum.PAY);
		stateMachine.sendEvent(EventEnum.RECEIVE);
	}
}
