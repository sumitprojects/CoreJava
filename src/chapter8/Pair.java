package chapter8;

import java.util.ArrayList;

public class Pair {
	private static ArrayList<Node<Integer, Integer>> list = new ArrayList<>();
	
	Pair (int a, int b) {
		list.add(new Node<>(a, b));
	}
	
	public static void display () {
		list.forEach(System.out::println);
	}
	
	public static void main (String[] args) {
		Pair p = new Pair(1, 2);
		//Pair p1 = new Pair(1, 2);
		Pair.display();
		System.out.println(p.getValue(1));
	}
	
	Integer getValue (Integer a) {
		for (Node<Integer, Integer> d : list) {
			if (d.getA() == a) {
				return d.getB();
			}
		}
		return -1;
	}
	
	private static class Node<K, V> {
		K a;
		V b;
		
		Node (K c, V d) {
			a = c;
			b = d;
		}
		
		public K getA () {
			return a;
		}
		
		public void setA (K a) {
			this.a = a;
		}
		
		public V getB () {
			return b;
		}
		
		public void setB (V b) {
			this.b = b;
		}
		
		@Override
		public String toString () {
			return "(" + a +
					", " + b +
					')';
		}
	}
}
