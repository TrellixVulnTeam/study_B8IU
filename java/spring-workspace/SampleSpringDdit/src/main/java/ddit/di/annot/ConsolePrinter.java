package ddit.di.annot;

import org.springframework.stereotype.Component;

@Component("${printer2}")
public class ConsolePrinter implements Printer {
	@Override
	public void print(String message) {
		System.out.println(message);
	}
}
