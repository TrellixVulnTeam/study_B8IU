package h_javaLang;

public class CloneTest_01 {
	public static void main(String[] args) {
		CloneEX c = new CloneEX(8, 4);
		CloneEX clone = null;
		
		if (c.clone() instanceof CloneEX) {
			clone = (CloneEX) c.clone();
		}
		
		System.out.println(c);
		System.out.println(clone);
		
		System.out.println();
		System.out.println("===============");
		System.out.println();
		clone.x = 50;
		System.out.println(c);
		System.out.println(clone);
		
		CloneEX c1 = new CloneEX(88, 5);
		CloneEX c2 = new CloneEX(88, 7);
		CloneEX c3 = new CloneEX(88, 6);
	}
}

class CloneEX implements Cloneable {
	int x;
	int y;
	
	public CloneEX(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	protected Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}

	@Override
	public String toString() {
		return "CloneEX [x=" + x + ", y=" + y + "]";
	}
}
