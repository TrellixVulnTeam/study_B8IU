package myspring.user.service;

import java.util.List;

import myspring.user.vo.UserVO;

public interface UserService {
	public void insertUser(UserVO userVO);

	public List<UserVO> getUserList();

	public UserVO getUser(String userId);

	public void updateUser(UserVO userVO);

	public void deleteUser(String userId);
}
