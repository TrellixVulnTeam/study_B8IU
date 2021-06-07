package guestbook.service;

//서비스 클래스들이 DAO를 실행하는 도중
//SQLException이 발생하면 발생시키도록 함
public class ServiceException extends RuntimeException {
	public ServiceException(String message, Exception cause) {
		super(message, cause);
	}
	public ServiceException(String message) {
		super(message);
	}
}
