import chapter3.packages.First;

public class TestClassDemo extends First {
	//	static double func (double x) {
//		return 2 * x * x - 12 * x + 7;
//	}
//
//
//	static double ts (double start, double end) {
//		double l = start, r = end;
//
//		for (int i = 0; i < 200; i++) {
//			double l1 = (l * 2 + r) / 3;
//			double l2 = (2 * r + l) / 3;
//			if (func(l1) > func(l2)) l = l2;
//			else r = l1;
//		}
//
//		double x = l;
//		return func(x);
//	}
//
//	public static void main (String[] args) throws Exception {
//		long n = 0, i = 0;
//		Scanner s = new Scanner(System.in);
//		n = s.nextLong();
//		Double[] res = new Double[(int) n];
//		for (i = 0; i < n; i++) {
//			Double l = s.nextDouble();
//			Double r = s.nextDouble();
//			res[(int) i] = Math.abs(ts(l, r));
//		}
//
//		for (Double d : res) {
//			System.out.println(d.intValue());
//		}
//	}
	public static void main (String[] args) {
		TestClassDemo first = new TestClassDemo();
		first.meth();
	}
}
