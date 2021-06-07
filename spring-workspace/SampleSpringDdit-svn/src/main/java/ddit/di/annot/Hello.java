package ddit.di.annot;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hello {
	@Value("${myname}")
	private String name;
	//Autowired는 Type을 이용하고, Resource는 Name을 이용한다.
//	@Autowired
//	@Qualifier("${printer1}")
	@Resource(name="${printer1}")
	private Printer printer;
	
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public Printer getPrinter() {
		return printer;
	}
//	public void setPrinter(Printer printer) {
//		this.printer = printer;
//	}
	
	public String sayHello() {
		return "Hello " + name;
	}
	
	public void print() {
		this.printer.print(sayHello());
	}
}



