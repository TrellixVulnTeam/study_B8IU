package guestbook.model;

public class Message {
	private int messageId;
	private String guestName;
	private String password;
	private String message;

	public int getMessageId() {
		return messageId;
	}

	public String getGuestName() {
		return guestName;
	}

	public String getPassword() {
		return password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean hasPassword() {
		return password != null && !password.isEmpty();
	}

	public boolean matchPassword(String pwd) {
		return password != null && password.equals(pwd);
	}
}
