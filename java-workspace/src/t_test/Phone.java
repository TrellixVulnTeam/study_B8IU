package t_test;

public class Phone {
	
	static Camera camera;
	static Screen screen;
	static Speaker speaker;
	
	String password;
 
	public static void main(String[] args) {

		camera = new Camera();
		screen = new Screen();
		speaker = new Speaker();
		
	}
	
}

class Camera {
	
	int glass;
	
}

class Screen {
	
	int glass;
	
}

class Speaker {
	
	String etc;
	
}
