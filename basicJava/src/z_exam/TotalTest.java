package z_exam;

public class TotalTest {
//	프로그램이 실행되며, Method Area에 TotalTest가 Class 변수, Class Method와 함께 생성된다.
	
//	Total Test
//	Class 변수 :
//	Class Method : main()
	public static void main(String[] args) {
//		main()메서드가 Call Stack()에서 시작된다.

		TvMaker.color = "Blue"; //
//		Method Area에 TvMaker 클래스가 Class 변수, Class Method와 함께 생성된다.
		
//		TvMaker
//		Class 변수 : color, inch
//		Class Method :
//		생성 시 String형은 null, int형은 0으로 초기화된다.
//		따라서 color = null, inch = 0으로 초기화되었다.
		
//		Method Area에 저장되어 있는 TvMaker의 클래스 변수 color를 Blue로 지정한다.
		
		TvMaker tm = new TvMaker();
//		대입연산자이므로 왼쪽부터 확인한다.
//		좌측 TvMaker는 이미 Method Area에 존재함을 확인한다.
//		Call Stack에서 main()의 지역변수 tm을 생성한다.
		
//		대입연산자의 우측을 확인한다.
//		TvMaker Class가 인스턴스화 되어 인스턴스가 Heap Area에 생성된다.
//		인스턴스 변수와와 인스턴스 Method가 함께 생성된다.
		
//		인스턴스 변수 : name, age
//		인스턴스 메서드 : TvMaker(), TvMaker(String, int)
//		생성 시 String형은 null, int형은 0으로 초기화된다.
//		따라서 name = null, age = 0으로 초기화되었다.
		
//		이후 Call Stack에 매개변수가 없는 TvMaker의 생성자가 호출된다.
		
//		매개변수가 없는 TvMaker 생성자는 String과 int 매개변수를 갖는 생성자를 호출하며, "man"과 25를 인자로 전달한다.
//		호출된 생성자는 Call Stack에 쌓인다.
//		이 때 매개변수는 지역변수로서 name과 age에 각각 "man"과 25의 값을 가진다.
//		전달된 매개변수는 인스턴스 변수의 값을 바꾼다.
//		name = "man", age = 25로 값이 변경된다.
//		영역 끝까지 실행을 마친 String과 int를 매개변수로 갖는 TvMaker의 생성자가 Call Stack에서 실행을 종료한다.
//		영역 끝까지 실행을 마친 매개변수가 없는 TvMaker의 생성자가 Call Stack에서 실행을 종료한다.
		
//		생성한 TvMaker의 주소를 tm에 대입한다.
		
		tm.age = 30; //
		// 3. 메서드 호출
		// 3.1
//		지역변수 tm에서 주소를 받아 Heap Area의 해당 영역에서 age를 30으로 변경한다. 
		
		System.out.println(TvControll.channel);
//		TvControll Class가 Method Area에 존재하지 않기 때문에 TvControll Class를  Method Area에 생성한다.
//		Method Area에 TvControll Class가 Class 변수, Class Method와 함께 생성된다.
		
//		TvControll
//		Class 변수 : MAX_CHANNEL = 50, MIN_CHANNEL = 1, channel = 15
//		Class Method : volumeDown()
		
//		TvControll의 Class변수 channel을 출력한다.
//		여기서는 15가 출력된다.
		
		TvControll.volumeDown();
//		TvControll Class가 Method Area에 존재하는지 확인한다. 
//		실행된 메서드는 Call Stack에 쌓인다.
//		TvControll의 Class Method인 volumeDown()을 실행한다.
//		volumeDown() Method는 channel이 MAX_CHANNEL과 같다면 channel을 MIN_CHANNEL로,
//		그렇지 않다면 channel을 1 증가시키는 메소드이다.
//		따라서 여기서는 TvControll의 Class 변수인 channel이 16이 된다.
//		수행을 모두 마쳐 Call Stack에서 종료된다.
		
		System.out.println(TvControll.channel);
//		TvControll Class가 Method Area에 존재하는지 확인한다.
//		TvControll의 Class변수 channel을 출력한다.
//		여기서는 16이 출력된다.

		// 3.2
		TvControll tc; //
//		TvControll Class가 Method Area에 존재하는지 확인한다.
//		Call Stack에서 main()의 TvControll형 지역변수 tc를 선언한다.
		
		tc = new TvControll(); //
//		대입연산자는 좌측부터 실행된다.
//		main()의 지역변수 tc의 유무를 확인한다.
//		대입연산자의 우측을 실행한다.
//		우측 TvControol 객체가 Heap Area에 인스턴스 변수, 인스턴스 Method와 함께 생성된다.
		
//		인스턴스 변수 : MAX_VOLUME = 100, MIN_VOLUME = 0, volume = 99
//		인스턴스 메서드 : volumeUp()
		
//		생성된 우측 TvControll 인스턴스의 주소를 tc에 대입한다.
		
		System.out.println(tc.volume);
//		지역변수 tc에서 인스턴스의 주소값을 받아 Heap Area의 해당 인스턴스에서 volume의 값을 출력한다.
//		여기서는 99가 출력된다.
		
		tc.volumeUp();
//		지역변수 tc에서 인스턴스의 주소값을 받아 Heap Area의 해당 인스턴스에서 volumeUp() Method를 실행한다.
//		실행된 메서드는 Call Stack에 쌓인다.
//		volumeUP() Method는 volume이 MAX_VOLUME과 같다면 volume을 MIN_VOLUME로,
//		그렇지 않다면 volume을 1 증가시키는 메소드이다.
//		따라서 여기서는 tc의 인스턴스변수인 volume을 99에서 100으로 변경한다.
//		수행을 모두 마쳐 Call Stack에서 종료된다.
				
		System.out.println(tc.volume);
//		지역변수 tc에서 인스턴스의 주소값을 받아 Heap Area의 해당 인스턴스에서 volume의 값을 출력한다.
//		여기서는 100이 출력된다.
		
		tc.volumeUp();
//		지역변수 tc에서 인스턴스의 주소값을 받아 Heap Area의 해당 인스턴스에서 volumeUp() Method를 실행한다.
//		실행된 메서드는 Call Stack에 쌓인다.
//		volumeUP() Method는 volume이 MAX_VOLUME과 같다면 volume을 MIN_VOLUME로,
//		그렇지 않다면 volume을 1 증가시키는 메소드이다.
//		따라서 여기서는 tc의 인스턴스변수인 volume이 100으로 MAX_VOLUME과 동일하여,
//		그 값을 MIN_VOLUME인 0으로 변경한다.
//		수행을 모두 마쳐 Call Stack에서 종료된다.
		
		System.out.println(tc.volume);
//		지역변수 tc에서 인스턴스의 주소값을 받아 Heap Area의 해당 인스턴스에서 volume의 값을 출력한다.
//		여기서는 0이 출력된다.

		//
		Calc cc = new Calc();
//		대입연산자이므로 왼쪽부터 확인한다.
//		Calc Class가 Method Area에 있는지 확인한다.
//		Calc Class가 Method Area에 존재하지 않기 때문에, Calc Class가 Class 변수, Class Method와 함께 생성된다.
		
//		Calc
//		Class 변수 :
//		Class Method :
		
//		Method Area에 TvControll Class가 Class 변수, Class Method와 함께 생성된다.
		
//		TvControll
//		Class 변수 : MAX_CHANNEL = 50, MIN_CHANNEL = 1, channel = 15
//		Class Method : volumeDown()
		
//		Call Stack에서 main()의 지역변수 cc를 생성한다.
		
//		대입연산자의 우측을 확인한다.
//		Calc Class가 인스턴스화 되어 인스턴스가 Heap Area에 생성된다.
//		인스턴스 변수와와 인스턴스 Method가 함께 생성된다.
		
//		인스턴스 변수 : 
//		인스턴스 메서드 : add(int, int), add(long, int), minus(int, int)
		
//		생성한 TvMaker의 주소를 tm에 대입한다.
		
		System.out.println(cc.add(Integer.MAX_VALUE, 4));
//		cc.add(Integer.MAX_VALUE, 4) 수행 후 반환된 값을 출력한다.
//		main()의 지역변수 cc에서 주소를 확인하여 Heap 영역의 해당 주소에서 add(int, int) Method를 수행한다.
//		실행된 메서드는 Call Stack에 쌓인다.
//		지역변수 int a, int b에 Integer.MAX_VALUE, 4가 각각 대입된다.
//		a = Integer.MAX_VALUE, b = 4;
//		
		
		System.out.println(cc.add(3L, Integer.MAX_VALUE));

	}
}

class TvMaker {
	// 1.
	// 1.1
	static String color;
	static int inch;
	// 1.2
	String name = "";
	int age;

	// 2.
	// 2.1
	TvMaker() {
		this("man", 25);
	}

	// 2.2
	TvMaker(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class TvControll {
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	static final int MAX_CHANNEL = 50;
	static final int MIN_CHANNEL = 1;

	static int channel = 15;
	int volume = 99;

	// 4. return문
	int volumeUp() {
		if (volume == MAX_VOLUME) {
			volume = MIN_VOLUME;
		} else {
			volume++;
		}

		return volume;
	}

	static int volumeDown() {
		if (channel == MAX_CHANNEL) {
			channel = MIN_CHANNEL;
		} else {
			channel++;
		}
		return channel;
	}
}

class Calc {
	// 5.
	int add(int a, int b) {
		return a + b;
	}

	long add(long a, int b) {
		return a + b;
	}

	int minus(int a, int b) {
		return a + b;
	}
}