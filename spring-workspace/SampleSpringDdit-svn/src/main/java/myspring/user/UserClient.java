package myspring.user;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class UserClient {
	@Autowired
	ApplicationContext context;
	@Autowired
	@Qualifier("userServiceImpl")
	UserService service;
	
	@Test
	public void getUserText() {
		UserVO user= service.getUser("gildong");
		System.out.println(user.toString());
		assertEquals("김은대", user.getName());
	}
}
