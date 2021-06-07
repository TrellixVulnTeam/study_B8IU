package ddit.di.xml.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ddit.di.xml.Hello;
import ddit.di.xml.Printer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")	//설정파일의 이름 지정
public class HelloBeanSpringTest {
	@Autowired	//빈 자동주입 어노테이션
	ApplicationContext context;
	
	//Ignore : 테스트를 수행하지 않음
	@Test @Ignore
	public void bean2() {
		Printer printer = (Printer)context.getBean("printer");
		Printer printer2 = context.getBean("printer", Printer.class);
		
		//객체1와 객체2가 같은 객체인지 비교
		//assertEquals : 값 비교   /   assertSame : 객체 비교
		assertSame(printer, printer2);
	}
	
	@Test
	public void bean1() {
		Hello hello = (Hello)context.getBean("hello");
		assertEquals("Hello Spring",hello.sayHello());	//Hello Spring		
		
		hello.print();
		Printer printer = (Printer)context.getBean("printer");
		assertEquals("Hello Spring", printer.toString());
		
		log.info(hello.getNames().size()+"");
		
		List<String> list = hello.getNames();
		
		for (String value : list) {
			log.info(value);
		}
		
	}
}




