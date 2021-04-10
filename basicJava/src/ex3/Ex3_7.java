package ex3;

public class Ex3_7 {
    public static void main(String[] args) {
    	//반환값을 저장할 int형 변수 result를 선언하고 인자로 4를 factorial() 메소드에 전달하여 그 반환값을 저장
    	int result = factorial(4);
    	
        System.out.println(result);
    }

    static int factorial(int n) {
    	//int형 변수 result를 선언하고 0으로 초기화
    	int result = 0;
    	
        if (n == 1) {
            result = 1;
        } else {
            result = n * factorial(n - 1);
        }
        return result;
    }
}