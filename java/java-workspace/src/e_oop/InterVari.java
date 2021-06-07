package e_oop;

class Data {
	int x;
}

public class InterVari {
	public static void main(String[] args) {
//		1. Data Class의 객체를 만들어주세요.
//			- 객체명 : d1
		Data d1 = new Data();
		
//		2. d1의 x값을 10으로 변경해주세요.
		d1.x = 10;
		
//		3. d1의 x값을 출력해주세요.
//			→ main() 기본형 : xx
		System.out.println("main() 기본형 : " + d1.x);
		
//		4. change 메서드를 호출해주세요.
//			- 인자값으로 d1의 x값을 주세요.
		InterVari.change(d1.x);
		
//		4.5. d1의 x값을 출력해주세요.
//			→ change() 기본형 : x
		System.out.println("change() 기본형 : " + d1.x);
		
//		5. Data 클래스의 객체를 만들어주세요.
//			- 객체명 : d2
		Data d2 = new Data();
		
//		6. d2의 x값을 10으로 변경해주세요.
		d2.x = 10;
		
//		7. d2의 x값을 출력해주세요.
//			→ main() 기본형 : xx
		System.out.println("main() 기본형 : " + d2.x);
		
//		8. change 메서드를 호출해주세요.
//			인자값으로 d2를 주세요.
		InterVari.change(d2);
		
//		8.5. d2의 x값을 출력해주세요.
//			→ change() 참조형 : x
		System.out.println("change() 참조형 : " + d2.x);
	}
	
	static void change(int x){
		 x = 1000;
		 System.out.println(x);
	}
	
	static void change(Data d1){
		d1.x = 1000;
		System.out.println(d1.x);
	}
}
