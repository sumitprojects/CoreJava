import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class SetCollection {
	public static void main (String[] args) {
		LinkedList<Integer> data = new LinkedList<>();
		data.add(2);
		data.add(3);
		data.add(1);
		data.add(4);
		data.add(1);
		System.out.println(data);
		
		HashSet<Integer> d = new HashSet<>();
		d.addAll(data);
		System.out.println(d);
		
		
		LinkedHashSet<Integer> ld = new LinkedHashSet<>();
		ld.addAll(data);
		System.out.println(ld);
		
		TreeSet<Student> ts = new TreeSet<>();
		ts.add(new Student(1, "Sumit"));
		ts.add(new Student(2, "Sumit"));
		ts.add(new Student(1, "Sumit"));
		ts.add(new Student(4, "Sumit"));
		ts.add(new Student(1, "Sumit"));
		System.out.println(ts);
	}
}
