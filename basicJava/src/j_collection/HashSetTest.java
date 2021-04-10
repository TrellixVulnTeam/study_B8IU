package j_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		
//		for (int i = 0; i < 10; i++) {
//			int random = (int)(Math.random() * 5);
//			boolean result = set.add(random);
//			System.out.println(result);
//		}
//		
//		System.out.println(set);
		
		//1. 로또번호 6개 저장하기.
		
		while (set.size() < 6) {
			int random = (int)(Math.random() * 45 + 1);
			set.add(random);
		}
		System.out.println(set);
		
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		System.out.println(list);
	}
}
