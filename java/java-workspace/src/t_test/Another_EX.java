package t_test;

public class Another_EX {
	public static void main(String[] args) {
		Another ano = new Another();
		
		System.out.println(ano.method1());
	}
}

class Another{
	static int c = 0;
	
	int method1(){
		return this.c;
	}
}