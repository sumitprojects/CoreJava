/* IMPORTANT: Multiple classes and nested static classes are supported */
 
/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass2 {
	
	public static void main (String[] args) throws IOException {
		int i, l, r;
		Scan s = new Scan();
		int n = s.scanInt(), k = s.scanInt();
		Long[] list = new Long[n + 5];
		for (i = 1; i <= n; i++)
			list[i] = (long) s.scanInt();
		l = (n + 1) / 2;
		r = (n + 1) / 2;
		
		boolean odd = n % 2 != 0;
		for (i = 1; i <= k; i++) {
			boolean par = (i % 2 != 0) ^ odd;
			if (par)
				r++;
			else
				l--;
		}
		long maxNumber = 0L;
		maxNumber = Collections.max(Arrays.asList(list).subList(l, r + 1));
		System.out.println(maxNumber);
	}
	
	static class Scan {
		private byte[] buf = new byte[1024];
		private int index;
		private InputStream in;
		private int total;
		
		public Scan () {
			in = System.in;
		}
		
		public int scan () throws IOException {
			if (total < 0)
				throw new InputMismatchException();
			if (index >= total) {
				index = 0;
				total = in.read(buf);
				if (total <= 0)
					return -1;
			}
			return buf[index++];
		}
		
		public int scanInt () throws IOException {
			int integer = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				} else throw new InputMismatchException();
			}
			return neg * integer;
		}
		
		public double scanDouble () throws IOException {
			double doub = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n) && n != '.') {
				if (n >= '0' && n <= '9') {
					doub *= 10;
					doub += n - '0';
					n = scan();
				} else throw new InputMismatchException();
			}
			if (n == '.') {
				n = scan();
				double temp = 1;
				while (!isWhiteSpace(n)) {
					if (n >= '0' && n <= '9') {
						temp /= 10;
						doub += (n - '0') * temp;
						n = scan();
					} else throw new InputMismatchException();
				}
			}
			return doub * neg;
		}
		
		public String scanString () throws IOException {
			StringBuilder sb = new StringBuilder();
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			while (!isWhiteSpace(n)) {
				sb.append((char) n);
				n = scan();
			}
			return sb.toString();
		}
		
		private boolean isWhiteSpace (int n) {
			return n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1;
		}
	}
	
	static class Print {
		private final BufferedWriter bw;
		
		public Print () {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}
		
		public void print (String str) throws IOException {
			bw.append(str);
		}
		
		public void printLine (String str) throws IOException {
			print(str);
			bw.append("\n");
		}
		
		public void close () throws IOException {
			bw.close();
		}
	}
}