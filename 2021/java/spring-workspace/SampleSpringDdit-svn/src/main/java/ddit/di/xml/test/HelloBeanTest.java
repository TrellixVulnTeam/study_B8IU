package ddit.di.xml.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ddit.di.xml.Hello;
import ddit.di.xml.Printer;

public class HelloBeanTest {
	ApplicationContext context;
	
	@Before
	public void init() {
		//컨테이너
		context = new GenericXmlApplicationContext("config/beans.xml");
	}
	@Test
	public void bean2() {
		Printer printer = (Printer)context.getBean("printer");
		Printer printer2 = context.getBean("printer", Printer.class);
		
		//객체1와 객체2가 같은 객체인지 비교
		//assertEquals : 값 비교   /   assertSame : 객체 비교
		assertSame(printer, printer2);
	}
	
	//Ignore : 테스트를 수행하지 않음
	@Test @Ignore
	public void bean1() {
		Hello hello = (Hello)context.getBean("hello");
		assertEquals("Hello Spring",hello.sayHello());	//Hello Spring		
		
		hello.print();
		Printer printer = (Printer)context.getBean("printer");
		assertEquals("Hello Spring", printer.toString());
		
	}
}




