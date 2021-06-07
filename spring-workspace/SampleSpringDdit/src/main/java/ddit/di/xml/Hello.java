package ddit.di.xml;

import java.util.List;

public class Hello {
	private String name;
	private Printer printer;
	private List<String> names;
	
	public Hello() {
		
	}

	public Hello(String name, Printer printer, List<String> names) {
		super();
		this.name = name;
		this.printer = printer;
		this.names = names;
	}

	public String getName() {
		return name;
	}

	public Printer getPrinter() {
		return printer;
	}

	public List<String> getNames() {
		return names;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}
}
