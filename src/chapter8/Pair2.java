package chapter8;

import java.util.HashMap;
import java.util.Map;

public class Pair2 {
	public static void main (String[] args) {
		HashMap<Integer, Integer> list = new HashMap<>();
		list.put(null, null);
		list.putIfAbsent(2, 5);
		list.putIfAbsent(null, 5);
		list.putIfAbsent(1, 5);
		//list.remove(2, null);
		System.out.println("Keys : " + list.keySet());
		System.out.println("Value : " + list.values());
		for (Map.Entry d : list.entrySet()) {
			System.out.println(d.getKey() + " " + d.getValue());
		}
		
		
		System.out.println(list.entrySet().stream().mapToDouble(Map.Entry::getValue).average().getAsDouble());
		list.entrySet().stream().filter(K -> (K != null)).forEach(System.out::println);
	}
}
