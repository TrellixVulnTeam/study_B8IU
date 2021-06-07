package kr.or.bio.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import kr.or.bio.bioVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/bioBeans.xml")
public class BIOController {
	@Autowired
	ApplicationContext context;
	
	@Test
	public void bean1() {
		bioVo vo = (bioVo)context.getBean("bioVo");
		log.info(vo.sayHello());	//bio "화이자"
		//예상값, 실제값 비교
		assertEquals("bio pfizer", vo.sayHello());
		
		bioVo vo2 = context.getBean("bioVo", bioVo.class);
		log.info(vo.sayHello());	//bio "화이자"
		//싱글턴 체킹(레퍼런스 비교)
		assertSame(vo,vo2);
	}
}




