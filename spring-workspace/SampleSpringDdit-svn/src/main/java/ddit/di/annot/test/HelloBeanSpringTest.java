package ddit.di.annot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ddit.di.annot.Hello;
import ddit.di.annot.Printer;
import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/annot.xml")
public class HelloBeanSpringTest {
	@Autowired
	ApplicationContext context;
	@Test
	public void test1() {
		Hello hello = (Hello)context.getBean("hello");
		log.info(hello.sayHello());
		assertEquals("Hello Spring", hello.sayHello());	//Hello Spring
		//this.printer.print(sayHello())
		//this.printer -> Qualifier("stringPrinter") -> stringPrinter
		//결국은.. stringPrinter.print(sayHello())
		//sayHello() : Hello Spring 이 문자열을 buffer에 넣음
		hello.print();
		
		Printer printer = context.getBean("stringPrinter",Printer.class);
		log.info(printer.toString());	//Hello Spring
		assertEquals("Hello Spring", printer.toString());
	}
}





