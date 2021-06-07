package guestbook.service;

//방명록 기능을 제공. 비밀번호 오류
public class InvalidPasswordException extends ServiceException {
	public InvalidPasswordException(String message) {
		super(message);
	}
}
