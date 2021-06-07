package myspring.user.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UserVO {
	private String userId;
	private String name;
	private String gender;
	private String city;
	
	@Override
	public String toString() {
		return "UserVO [userId = \"" + userId + "\", name = \"" + name + "\", gender = \"" + gender + "\", city = \"" + city + "\"]";
	}
}
