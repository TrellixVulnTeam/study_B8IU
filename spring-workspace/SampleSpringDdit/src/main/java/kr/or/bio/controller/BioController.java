package kr.or.bio.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.bio.BioVo;
import lombok.extern.java.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/bio.xml")
@Log
public class BioController {
	@Autowired
	ApplicationContext applicationContext;
	
	@Test
	public void bean01() {
		BioVo bioVo = (BioVo) applicationContext.getBean("bioVo");
		log.info(bioVo.sayHello());
		Assert.assertEquals("화이자", bioVo.getReceiptName());
		
		BioVo bioVo2 = applicationContext.getBean("bioVo", BioVo.class);
		Assert.assertSame(bioVo, bioVo2);
	}
}
