package t_test;

public class CarCls {
	
	Point2 p = new Point2();
	int r;
	
	CarCls(){
		p.x = 10;
		p.y = 20;
	}
	
	public static void main(String[] args) {
		CarCls c  = new CarCls();
	}
}

class Point2 {
	
	int x;
	int y;
	
}

class Eclipse extends CarCls{
	
	int 찌그러짐;
	Eclipse(){
		super();
	}
}