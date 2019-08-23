import java.util.*;

class Student implements Comparable<Student> {
	private int id;
	private String name;

	Student() {
	}

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}

	@Override
	public int compareTo(Student student) {
		if (id > student.id) {
			return -1;
		} else if (id < student.id) {
			return 1;
		}
		return 0;
	}
}

public class DemoCollections {

	public static void main(String[] args) {

		/*
		 * List Set Map
		 *
		 *
		 * List
		 * ArrayList
		 * LinkedList
		 *
		 *
		 * Set
		 * HashSet
		 * LinkedHashSet
		 * TreeSet
		 *
		 * Map
		 * HashMap
		 * LinkedHashMap
		 * TreeMap
		 * */


		TreeMap<Integer, String> datalist = new TreeMap<>();
		datalist.putIfAbsent(1, "sumit1");
		datalist.putIfAbsent(2, "sumit1");
		datalist.putIfAbsent(3, "sumit2");
		datalist.putIfAbsent(5, "sumit3");
		datalist.putIfAbsent(4, "sumit4");
		if (!datalist.containsKey(9)) {
			datalist.put(9, "sumit9");
		}
		System.out.println(datalist);
		System.out.println(datalist.values());
		System.out.println(datalist.keySet());
		for (Map.Entry d : datalist.entrySet()) {
			System.out.println(d.getKey() + " " + d.getValue());
		}
		System.exit(0);
		TreeSet<Student> data1 = new TreeSet<>();
		Student ss = new Student(1, "Sumit");
		data1.add(ss);
		data1.add(ss);
		data1.add(ss);
		data1.add(ss);
		data1.add(new Student(2, "Sumit"));
		data1.add(new Student(3, "Sumit"));
		data1.add(new Student(4, "Sumit"));
		data1.add(new Student(5, "Sumit"));

		LinkedList<Student> data = new LinkedList<>();
		data.add(new Student(1, "Sumit"));
		data.add(new Student(2, "Sumit"));
		data.add(new Student(3, "Sumit"));
		data.add(new Student(4, "Sumit"));
		data.add(new Student(5, "Sumit"));

//		System.out.println(data);
		data1.addAll(data);
		System.out.println(data1);

		ArrayList<Integer> data2 = new ArrayList<>();
		data2.add(12);
		data2.add(0, 120);
		System.out.println(data2);

		LinkedList<Integer> data3 = new LinkedList<>();
		data3.add(125);
		data3.addAll(1, data2);
		System.out.println(data3);

		data3.retainAll(data2);
		System.out.println(data3);

		ArrayList lists = new ArrayList<>();
		lists.add(data);
		lists.add(data2);
		lists.add(data3);
		System.out.println(lists);

		System.out.println(lists.subList(0, 1));

//	    if (data2.contains(12))
//		{
//			System.out.println("Yes");
//		}else {
//			System.out.println("No");
//		}
//
//		if (lists.contains(12))
//		{
//			System.out.println("Yes");
//		}else {
//			System.out.println("No");
//			System.out.println(lists.get(2));
//		}
		//System.out.println(lists);
		System.out.println("----------------------------------");
		for (int i = 0; i < data2.size(); i++) {
			System.out.println(data2.get(i));
		}
		System.out.println("----------------------------------");
		System.out.println("----------------------------------");

		for (Integer d : data2) {
			System.out.println(d);
		}
		System.out.println("----------------------------------");
		lists.forEach(System.out::println);
	}
}
