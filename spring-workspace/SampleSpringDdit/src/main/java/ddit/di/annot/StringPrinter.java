package ddit.di.annot;

import org.springframework.stereotype.Component;

@Component("${printer1}")
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
