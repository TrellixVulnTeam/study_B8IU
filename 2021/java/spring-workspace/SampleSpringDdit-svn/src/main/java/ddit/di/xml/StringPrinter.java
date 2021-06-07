package ddit.di.xml;

public class StringPrinter implements Printer {
	//StringBuffer 객체 생성
	private StringBuffer buffer = new StringBuffer();
	
	//입력받은 메시지를 buffer에 append함
	@Override
	public void print(String message) {
		buffer.append(message);
	}
	
	//String buffer에 저장된 message를 return
	public String toString() {
		return buffer.toString();
	}

}
