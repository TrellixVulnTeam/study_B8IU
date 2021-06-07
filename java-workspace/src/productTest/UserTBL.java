package productTest;

import java.util.Vector;

public class UserTBL {
	Vector<UserVO> userList = new Vector<UserVO>();
	
	boolean insert(String name, int money) {
		return insert(name, money, 0);
	}
	
	boolean insert(String name, int money, int mileage) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getName() == name) {
				return false;
			}
		}
		
		UserVO user = UserVO.insert(name, money, mileage);
		userList.add(user);
		
		return true;
	}
	
	boolean update(UserVO user, int money) {
		return update(user, money, user.getMileage());
	}
	
	boolean update(UserVO user, int money, int mileage) {
		if (userList.contains(user)) {
			user.setMoney(money);
			user.setMileage(mileage);
			return true;
		}
		return false;
	}
	
	boolean delete(UserVO user) {
		if (userList.remove(user)) {
			return true;
		}
		return false;
	}
	
	UserVO select(String name) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getName() == name) {
				return userList.get(i);
			}
		}
		return null;
	}
}
