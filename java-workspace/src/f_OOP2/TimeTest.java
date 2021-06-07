package f_OOP2;


public class TimeTest {
	public static void main(String[] args) {
//		TimeVO time = new TimeVO();
//		time.setHour(70);
//		int hour = time.getHour();
//		System.out.println(hour);
		
		TimeVO time1 = new TimeVO();
		System.out.println("Time 1");
//		시간	6
		time1.setHours(6);
		System.out.println(time1.getHours() + " : " + time1.getMinutes() + " : " + time1.getSeconds());
		
//		분	356 → 11 : 56
		time1.setMinutes(356);
		System.out.println(time1.getHours() + " : " + time1.getMinutes() + " : " + time1.getSeconds());
		
//		초	7200 + 60 + 53 → 7313 → 13 : 57 : 53
		time1.setSeconds(7313);
		System.out.println(time1.getHours() + " : " + time1.getMinutes() + " : " + time1.getSeconds());
		
		System.out.println("=================");
		TimeVO time2 = new TimeVO();
		System.out.println("Time 2");
//		시간	22
		time2.setHours(22);
		System.out.println(time2.getHours() + " : " + time2.getMinutes() + " : " + time2.getSeconds());
		
//		분	1434 → 21 : 54
		time2.setMinutes(1434);
		System.out.println(time2.getHours() + " : " + time2.getMinutes() + " : " + time2.getSeconds());
		
//		초	10800 + 600 + 23 → 11423 → 1 : 04 : 23 
		time2.setSeconds(11423);
		System.out.println(time2.getHours() + " : " + time2.getMinutes() + " : " + time2.getSeconds());
	}
}

class TimeVO {
	private int hours;
	private int minutes;
	private int seconds;
	
	void setHours(int hours) {
		this.hours = hours % 24;
	}
	
	void setMinutes(int minutes) {
		this.minutes = minutes % 60;
		if (minutes >= 60) {
			setHours(hours + minutes / 60);
		}
	}
	
	void setSeconds(int seconds) {
		this.seconds = seconds % 60;
		if (seconds >= 60) {
			setMinutes(minutes + seconds / 60);
		}
	}

	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}
}
