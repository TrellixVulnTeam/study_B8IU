package ex3;

class TestData_1 {
	//int형 인스턴스 변수 value 선언
	int value;
}

class TestData_2 {
	//int형 인스턴스 변수 value 선언
	int value;
	TestData_2(int x) {
		//인스턴스 변수 value에 전달받은 인자 x 대입
		value = x;
	}
}

public class Ex3_8 {
	public static void main(String[] args) {
		//TestData_1인스턴스를 참조하기 위한 변수 td1을 선언 및 TestData_1인스턴스를 생성하여 저장
		TestData_1 td1 = new TestData_1();
		
		//TestData_2인스턴스를 참조하기 위한 변수 td2을 선언 및 TestData_2인스턴스를 생성하여 저장
		//TestData_2 td2 = new TestData_2();
	}
}