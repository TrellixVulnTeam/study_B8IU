package f_OOP2;

public class PolyTest {
	public static void main(String[] args) {
//		1. SmartTv 2대 저장해주세요.
		SmartTv smartTv1 = new SmartTv();
		SmartTv smartTv2 = new SmartTv();
		SmartTv[] smartTvArr = new SmartTv[2];
		smartTvArr[0] = smartTv1;
		smartTvArr[1] = smartTv2;
		  
//		2. AfreecaTv 3대 저장해주세요.
		AfreecaTv afreecaTv1 = new AfreecaTv();
		AfreecaTv afreecaTv2 = new AfreecaTv();
		AfreecaTv afreecaTv3 = new AfreecaTv();
		AfreecaTv[] afreecaTvArr = new AfreecaTv[3];
		afreecaTvArr[0] = afreecaTv1;
		afreecaTvArr[1] = afreecaTv2;
		afreecaTvArr[2] = afreecaTv3;
		
//		3. ThreeDTv 4대 저장해주세요.
		ThreeDTv threeDTv1 = new ThreeDTv();
		ThreeDTv threeDTv2 = new ThreeDTv();
		ThreeDTv threeDTv3 = new ThreeDTv();
		ThreeDTv threeDTv4 = new ThreeDTv();
		ThreeDTv[] threeDTvArr = new ThreeDTv[4];
		threeDTvArr[0] = threeDTv1;
		threeDTvArr[1] = threeDTv2;
		threeDTvArr[2] = threeDTv3;
		threeDTvArr[3] = threeDTv4;
		
		Tv[] tv = new Tv[9];
		tv[0] = smartTv1;
		tv[1] = smartTv2;
		tv[2] = afreecaTv1;
		tv[3] = afreecaTv2;
		tv[4] = afreecaTv3;
		tv[5] = threeDTv1;
		tv[6] = threeDTv2;
		tv[7] = threeDTv3;
		tv[8] = threeDTv4;
		
		AfreecaTv a = (AfreecaTv) tv[3];
		Tv b = new Tv();
		AfreecaTv c = (AfreecaTv)b;
	}
}

class Tv {
	boolean power;
	int channel;
	
	void power() {
		power = !power;
	}
	
	void channelUp() {
		channel++;
	}
	
	void channelDown() {
		channel--;
	}
}

class SmartTv extends Tv {
	void interNet() {
		
	}
}

class AfreecaTv extends Tv {
	void starBalloon() {
		
	}
}

class ThreeDTv extends Tv {
	void auziruwo() {
		
	}
}
