package ex3;

class Init {
	//int형 클래스 변수 action 선언
	static int action;
	
	//int형 인스턴스 변수 action2 선언하고 5로 초기화
	int action2 = 5;
	
    static { // 클래스 초기화 블럭
    	//action에 4 대입
    	action = 4;
    }
    { // 인스턴스 초기화 블럭
        //action2에 4 대입
    	action2 = 4;
    }

    Init() {
    	//action2에 7 대입
    	action2 = 7;
    }

    Init(int action2) {
        //매개변수가 없는 생성자 호출
    	this();
    	
    	//인스턴스변수 action2에 전달받은 인자 action2 대입
    	this.action2 = action2;
    }
}

public class Ex3_11 {
    public static void main(String[] args) {
    	//Init인스턴스를 참조하기 위한 변수 init를 선언 및 9를 인자로 전달하여 Init 인스턴스 생성 후 저장
    	Init init = new Init(9);
    }
}