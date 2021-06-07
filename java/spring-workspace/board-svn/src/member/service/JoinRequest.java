package member.service;

import java.util.Map;

public class JoinRequest {
	private String id;
	private String name;
	private String password;
	private String confirmPassword;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	//password 필드와 confirmPassword 필드 값이 같은지 검사.
	public boolean isPasswordEquialToConfirm() {
		return password != null && password.equals(confirmPassword);
	}
	
	//각 필드의 데이터가 유효한지 검사
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, id, "id");
		checkEmpty(errors, name, "name");
		checkEmpty(errors, password, "password");
		checkEmpty(errors, confirmPassword, "confirmPassword");
		if(!errors.containsKey("confirmPassword")) {
			//암호와 확인값이 일치하지 않으면 notMatch라는 에러키를 추가함
			if(!isPasswordEquialToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}
	
	
	//value가 null인 경우 처리
	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if(value==null || value.isEmpty()) {
			errors.put(fieldName, Boolean.TRUE);
		}
	}
}





