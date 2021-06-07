package ddit.di.xml;

public class StringPrinter implements Printer {
	private StringBuffer stringBuffer = new StringBuffer();
	
	@Override
	public void print(String message) {
		stringBuffer.append(message);
	}
	
	@Override
	public String toString() {
		return stringBuffer.toString();
	}
}
