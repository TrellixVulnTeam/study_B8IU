package myspring.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.user.mapper.UserMapper;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;
	
	@Override
	public void insertUser(UserVO userVO) {
		userMapper.insert(userVO);
	}

	@Override
	public List<UserVO> getUserList() {
		return userMapper.readAll();
	}

	@Override
	public UserVO getUser(String userId) {
		return userMapper.read(userId);
	}

	@Override
	public void updateUser(UserVO userVO) {
		userMapper.update(userVO);
	}

	@Override
	public void deleteUser(String userId) {
		userMapper.delete(userId);
	}
}
