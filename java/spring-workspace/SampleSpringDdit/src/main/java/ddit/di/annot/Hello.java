package ddit.di.annot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class Hello {
	@Value("${myName}")
	private String name;
	@Autowired
	@Qualifier("${printer1}")
	private Printer printer;

	public String sayHello() {
		return "Hello ".concat(name);
	}

	public void print() {
		printer.print(sayHello());
	}
}
