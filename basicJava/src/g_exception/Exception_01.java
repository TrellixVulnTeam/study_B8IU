package g_exception;

public class Exception_01 {
	public static void main(String[] args) {
		/*
		1. 프로그램 오류
			- 프로그램이 실행 중 어떤 오류에 의해서 오작동을 하거나 비정상적으로 종료되는 경우.
			- 컴파일 에러
				: 컴파일 시 발생하는 에러
			- 런타임 에러
				: 프로그램이 실행 시에 발생하는 오류
			- 에러
				: Error
				: 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
			- 예외
				: Exception
				: 프로그램 코드에 의해서 수습될 수 있는 경미한 오류
		*/
		
		/*
		2. RuntimeException 클래스와 그 외 클래스
			- 모든 예외의 최고 조상은 Exception이다.
			- RuntimeException 클래스들은 주로 프로그래머의 실수에 의해 발생할 수 있는 예외
				: IndexOutOfBoundsExeption, NullPointException, ···.
			- Exception 클래스들은 주로 외부의 영향으로 발생할 수 있는 것들
				: FileNotFoundsException, ClassNotFoundsException, ···.
		*/
		
		/*
		3. 예외처리 ( try - catch )
			- 프로그램 실행 시 발생할 수 있는 예외의 발생에 대비한 코드를 작성하는 것
			- 구조
				try {
					예외가 발생할 가능성이 있는 코드
				} catch (Exception e) {
					Exception이 발생하였을 때 처리할 문장.
				}
			- 발생할 예외의 종류와 일치하는 단 한개의 catch 블럭만 수행한다.
		*/
		
		/*
		4. 예외 발생 시키기
			- 연산자 new를 이용해서 예외를 발생시키려는 예외 클래스의 객체를 만들어준다.
				: Exception e = new Exception();
			- 키워드 throw를 이용해서 예외를 발생시키면 된다.
				: throw e;
			- 합치면
				: throw new Exception();
		*/
		
		/*
		5. 예외 던지기
			- 메서드의 선언부에 키워드 'throws'를 사용해서 메서드 내에서 발생할 수 있는 예외를 적어주기만 하면 된다.
			- 처리는 해당 메서드를 호출한 쪽에서 처리해 주면 된다.
		*/
		
		/*
		6. finally
			- try-catch 블럭의 예외발생에 상관없이 실행되어야 할 코드를 생성한다.
			- 구조
				try {
					예외가 발생할 가능성이 있는 코드
				} catch (Exception e) {
					예외가 발생하였을 때 처리할 코드
				} finally {
					예외 발생에 상관없이 실행되어야 할 코드
				}
		
			- 예외가 발생하지 않을 때
				: try → finally
			- 예외가 발생하였을 때
				: try → catch → finally
		*/
	}
}
