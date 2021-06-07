package j_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayList_01 {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		
		list1.add(new Integer(5));
		list1.add(new Integer(2));
		list1.add(new Integer(3));
		list1.add(new Integer(1));
		list1.add(new Integer(4));
		
		List<Integer> list2 = new ArrayList<>(list1.subList(1, 3));
		
		System.out.println(list1);
		System.out.println(list2);
		
		System.out.println(list1.containsAll(list2));
		System.out.println(list2.containsAll(list1));
		
		list1.add(1, 50);
		System.out.println(list1);
		list1.add(6, 90);
		System.out.println(list1);
		
		Integer i1 = list1.remove(2);
		System.out.println(i1);
		System.out.println(list1);
		
		System.out.println(list1.set(2, 900));
		System.out.println(list1);
		
		Collections.sort(list1);
		System.out.println(list1);
	}
}
