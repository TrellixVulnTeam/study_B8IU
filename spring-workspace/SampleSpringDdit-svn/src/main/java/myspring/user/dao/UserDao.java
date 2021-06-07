package myspring.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import myspring.user.vo.UserVO;

@Component("userDao")
public class UserDao {
	public void insert(UserVO user) {
		
	};
	
	public List<UserVO> readAll(){
		List<UserVO> list = null;
		
		return list;
	};
	
	public void update(UserVO user) {
		
	};
	
	public void delete(String id) {
		
	};
	
	public UserVO read(String id) {
		UserVO vo = new UserVO();
		
		vo.setUserId("a001");
		vo.setName("김은대");
		vo.setGender("남성");
		vo.setCity("대전");
		
		return vo;
	};
}
