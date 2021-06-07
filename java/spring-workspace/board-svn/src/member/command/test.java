package member.command;

import java.util.HashMap;
import java.util.Map;

public class test {
	
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		
		map.put("/test", "asdf");
		
		System.out.println("map : " + map);
		System.out.println(map.get("/test"));
	}
}
