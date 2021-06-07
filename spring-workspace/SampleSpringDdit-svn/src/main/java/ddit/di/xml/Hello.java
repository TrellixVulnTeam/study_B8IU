package ddit.di.xml;

import java.util.List;

public class Hello {
	//멤버변수
	private String name;
	//Printer 클래스
	private Printer printer;
	//List
	List<String> names;
	
	//List
	public void setNames(List<String> names) {
		this.names = names;
	}
	
	public List<String> getNames() {
		return names;
	}

	//setName -> Ctrl + space
	public void setName(String name) {
		this.name = name;
	}
	//setPrinter -> Ctrl + space
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	//메소드
	public String sayHello() {
		//Hello문자열과 name 멤버변수 결합
		return "Hello " + name;
	}
	
	public void print() {
		this.printer.print(sayHello());
	}
}






