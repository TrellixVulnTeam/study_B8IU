package myspring.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.java.Log;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
@Log
public class UserClient {
	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	@Qualifier("userServiceImpl")
	UserService userService;

	@Test
	public void getUserText() {
		UserVO userVO = userService.getUser("a001");
		log.info(userVO.toString());
		Assert.assertEquals("김은대", userVO.getName());
	}
}
