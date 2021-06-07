package myspring.user.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import myspring.user.vo.UserVO;

@Repository
public class UserMapper {
	public void insert(UserVO userVO) {
	}

	public List<UserVO> readAll() {
		return null;
	}

	public UserVO read(String userId) {
		UserVO userVO = new UserVO();
		userVO.setUserId(userId);
		userVO.setName("김은대");
		userVO.setGender("남");
		userVO.setCity("대전");

		return userVO;
	}

	public void update(UserVO userVO) {
	}

	public void delete(String userId) {
	}

}
