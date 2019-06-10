package chapter8;

import java.util.ArrayList;

public class Pair {
	private static ArrayList<Node> list = new ArrayList<>();
	
	Pair (int a, int b) {
		list.add(new Node(a, b));
	}
	
	public static void display () {
		list.forEach(System.out::println);
	}
	
	public static void main (String[] args) {
		Pair p = new Pair(1, 2);
		Pair p1 = new Pair(1, 2);
		Pair.display();
		System.out.println(p.getValue(1));
	}
	
	int getValue (int a) {
		for (Node d : list) {
			if (d.getA() == a) {
				return d.getB();
			}
		}
		return -1;
	}
	
	private class Node {
		int a;
		int b;
		
		Node (int c, int d) {
			a = c;
			b = d;
		}
		
		public int getA () {
			return a;
		}
		
		public void setA (int a) {
			this.a = a;
		}
		
		public int getB () {
			return b;
		}
		
		public void setB (int b) {
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
