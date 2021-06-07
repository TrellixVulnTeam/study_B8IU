package ddit.di.annot.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ddit.di.annot.Hello;
import ddit.di.annot.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/annot.xml")
public class HelloBeanSpringTest {
	@Autowired
	ApplicationContext applicationContext;
	
	@Test
	public void bean01() {
		Hello hello = applicationContext.getBean(Hello.class);
		Assert.assertEquals("Hello Spring", hello.sayHello());
		hello.print();
		
		Printer printer = applicationContext.getBean("${printer1}", Printer.class);
		Assert.assertEquals("Hello Spring", printer.toString());
	}
}
