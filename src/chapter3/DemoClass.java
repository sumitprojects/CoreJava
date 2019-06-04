package chapter3;

public class DemoClass {
	String name;
	
	DemoClass () {
		System.out.println("I am constructor");
	}
	
	DemoClass (String message) {
		name = message;
	}
	
	public static void main (String[] args) {
		DemoClass demoClass = new DemoClass("Sumit");
		Abc abc = new Abc();
		System.out.println(demoClass);
	}
}

class Abc {
	Abc () {
		System.out.println("I am constrctor of Abc");
	}
}