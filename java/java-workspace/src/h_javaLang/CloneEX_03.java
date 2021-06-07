package h_javaLang;

public class CloneEX_03 {
	public static void main(String[] args) {
		Circle c = new Circle(new Point(100, 100), 50);
		System.out.println(c);
		
		Circle cCopy = c.shallowCopy();
		System.out.println(cCopy);
		
		System.out.println();
		System.out.println("============");
		System.out.println();
		
		c.r = 300;
		c.p.x = 1000;
		System.out.println(c);
		System.out.println(cCopy);
	}
}

class Circle implements Cloneable {
	Point p;
	int r;
	Circle(Point p, int r) {
		this.p = p;
		this.r = r;
	}

	@Override
	public String toString() {
		return "Circle [p=" + p + ", r=" + r + "]";
	}
	
	protected Circle shallowCopy() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (Circle) clone;
	}
	
	protected Circle deepCopy() {
		Circle clone = null;
		try {
			clone = (Circle)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		Point newP = new Point(p.x, p.y);
		clone.p = newP;
		
		return  clone;
	}
}
