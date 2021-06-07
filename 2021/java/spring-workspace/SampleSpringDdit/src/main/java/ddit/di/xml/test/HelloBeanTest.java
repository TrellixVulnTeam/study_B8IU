package ddit.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ddit.di.xml.Hello;
import ddit.di.xml.Printer;
import lombok.extern.java.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
@Log
public class HelloBeanTest {
	@Autowired
	ApplicationContext applicationContext;

	@Test
	public void bean1() {
		Printer printer = (Printer) applicationContext.getBean("printer");
		Printer printer2 = applicationContext.getBean("printer", Printer.class);
		assertSame(printer, printer2);
	}

	@Test
	public void bean2() {
		Hello hello = (Hello) applicationContext.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());

		hello.print();
		Printer printer = (Printer) applicationContext.getBean("printer");
		assertEquals("Hello Spring", hello.sayHello());

		log.info(hello.getNames().size() + "");
		
		for (String name : hello.getNames()) {
			log.info(name);
		}
	}
}
