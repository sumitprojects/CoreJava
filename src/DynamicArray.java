import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DynamicArray {
	private static int counter = 0;
	Object[] dynamicArray = new Object[1];
	
	private DynamicArray () {
	
	}
	
	public static void main (String[] args) {
		DynamicArray d = new DynamicArray();
		d.add(10);
		d.add(30);
		d.add(40);
		d.add(50);
		d.add(60);
		d.display();
		System.out.println(d.get(10));
		List<Integer> data = new ArrayList<>();
		data.add(20);
		data.add(40);
		data.add(50);
		data.add(60);
//		data.remove(2);
		//System.out.println(data);
		//d.add(data);
		//d.display();
		Iterator iterator = data.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

//		System.out.println("sublist " + data.subList(1, 2));
//		data.forEach(System.out::println);
//		data.offerFirst(10);
//		data.add(2, 10);
//		data.add(4, 10);
//		data.removeLastOccurrence(10);
		
		ArrayList<Integer> dd = new ArrayList<>();
		dd.addAll(data);
//		data.retainAll(data.subList(1,2));
		data.forEach(a -> System.out.println("Retained value " + a));
	}
	
	public void add (Object data) {
		if (counter >= dynamicArray.length) {
			this.dynamicArray = Arrays.copyOf(dynamicArray, dynamicArray.length + 1);
		}
		dynamicArray[counter++] = data;
	}
	
	public void display () {
		for (Object num : dynamicArray) {
			System.out.println(num);
		}
	}
	
	private Object get (int index) {
		if (index > counter) {
			return "Index not Found.";
		} else {
			return dynamicArray[index];
		}
	}
}

