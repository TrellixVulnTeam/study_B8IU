package j_collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args) {
		Map<String, Integer> params = new HashMap<>();
		
		params.put("이종찬", new Integer(100));
		params.put("길정우", 30);
		params.put("이미라", 200);
		
		int jung = params.get("길정우");
		System.out.println(jung);
		
		params.remove("이종찬");
		
		System.out.println(params);
	}
}
