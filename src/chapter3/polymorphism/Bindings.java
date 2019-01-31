package chapter3.polymorphism;
/*
 * static binding (also known as early binding).
 * dynamic binding (also known as late binding).
 * */

class Animals {
	void disp () {
		System.out.println("Hello I am animal.");
	}
}

class Dog extends Animals {
	void disp () {
		System.out.println("Hello I am Dog");
	}
	
	void bark () {
		System.out.println("Barking");
	}
}

public class Bindings {
	public static void main (String[] args) {
		System.out.println("----------------------------------------------------------------");
		System.out.println("\t\t Static Binding");
		Animals a = new Animals();
		a.disp();
		System.out.println("----------------------------------------------------------------");
		Animals d = new Dog();
		System.out.println("\t\t Dynamic Binding");
		d.disp();
		//d.bark();
		System.out.println("----------------------------------------------------------------");
		
	}
}
