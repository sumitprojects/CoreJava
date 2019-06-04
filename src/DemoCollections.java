import java.util.ArrayList;
import java.util.LinkedList;

class Student implements Comparable<Student> {
	private int id;
	private String name;
	
	Student () {
	}
	
	public Student (int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString () {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
	
	@Override
	public int compareTo (Student student) {
		if (id > student.id) {
			return -1;
		} else if (id < student.id) {
			return 1;
		}
		return 0;
	}
}

public class DemoCollections {
	
	public static void main (String[] args) {
		LinkedList<Student> data = new LinkedList<>();
		data.add(new Student(1, "Sumit"));
		data.add(new Student(2, "Sumit"));
		data.add(new Student(3, "Sumit"));
		data.add(new Student(4, "Sumit"));
		data.add(new Student(5, "Sumit"));
		
		
		System.out.println(data.get(1));
		
		ArrayList<Integer> data2 = new ArrayList<>();
		data2.add(12);
		data2.add(0, 120);
		System.out.println(data2);
		
		LinkedList<Integer> data3 = new LinkedList<>();
		data3.add(125);
		data3.addAll(1, data2);
		
		data3.retainAll(data2);
		System.out.println(data3);
		
		ArrayList lists = new ArrayList<>();
		lists.add(data);
		lists.add(data2);
		lists.add(data3);
		System.out.println(lists);
		
		
		System.out.println(lists.subList(0, 2));

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
		Integer[] d = {1, 23, 5, 4, 6};
		lists.forEach(System.out::println);
		
		
	}
}
