package Collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsDemo implements Serializable {
	public static void main (String[] args) {
		List<Integer> demo = new ArrayList<>();///runtime poly / dynamic binding / shared method
		demo.add(10);
		demo.add(10);
		demo.add(1, 22);
		demo.set(1, 24);
		demo.addAll(demo);
		System.out.println(demo);
		demo.forEach(System.out::println);
		System.out.println(demo.subList(1, 4));
		System.out.println(demo.stream().filter(a -> a > 10).collect(Collectors.toList()));
		LinkedList<Integer> demo2 = new LinkedList<>();///runtime poly / dynamic binding / shared method
		demo2.add(10);
		demo2.add(10);
		demo2.removeLastOccurrence(10);
		demo2.add(1, 22);
		demo2.set(1, 24);
		demo2.addAll(demo2);
		System.out.println(demo2);
		
		HashSet<Integer> dm = new HashSet<>();
		dm.addAll(demo);
		
		System.out.println(dm);
		
		demo.clear();
		demo.addAll(dm);
		System.out.println(demo);
	}
}
