package chapter8;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Pair2 {
	public static void main (String[] args) {
		TreeMap<Integer, Integer> list = new TreeMap<>();
		list.put(3, null);
		list.putIfAbsent(2, 5);
		list.putIfAbsent(3, 5);
		list.putIfAbsent(1, 5);
		
		
		//list.remove(2, null);
		System.out.println("Keys : " + list.keySet());
		System.out.println("Value : " + list.values());
		for (Map.Entry d : list.entrySet()) {
			System.out.println(d.getKey() + " " + d.getValue());
		}
		
		System.out.println("avg1 ->" + list.values().stream().mapToDouble(a -> a).average().getAsDouble());
		System.out.println("avg2 ->" + list.entrySet().stream().mapToDouble(Map.Entry::getValue).average().getAsDouble());
		System.out.println("map ->" + Arrays.toString(list.values().stream().map(k -> k * k).toArray()));
		//list.entrySet().stream().filter(K -> (K != null)).forEach(System.out::println);
	}
}
