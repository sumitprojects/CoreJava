package chapter2;

public class MethodTypes {
	public static void disp () {
		System.out.println("without parameter without return");
	}
	
	public static void add (int a, int b) {
		System.out.println("with parameter without return");
		System.out.println("a + b " + (a + b));
	}
	
	public static Integer sub () {
		
		System.out.println("without paremeter with return");
		return 10 - 2;
	}
	
	public static int mul (int a, int b) {
		System.out.println("with parameter with return");
		return a + b;
	}
	
	public static int fact (int n) {
		if (n == 1)
			return 1;
		else
			return n * fact(n - 1);
	}
	
	public static void main (String[] args) {
		System.out.println("----------------------------------------------------------------");
		disp();
		System.out.println("----------------------------------------------------------------");
		
		System.out.println("----------------------------------------------------------------");
		add(10, 20);
		System.out.println("----------------------------------------------------------------");
		
		System.out.println("----------------------------------------------------------------");
		System.out.println(sub());
		System.out.println("----------------------------------------------------------------");
		
		System.out.println("----------------------------------------------------------------");
		System.out.println(mul(10, 20));
		System.out.println("----------------------------------------------------------------");
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("Recursive Function");
		System.out.println(fact(5));
		System.out.println("----------------------------------------------------------------");
		
	}
	
}
