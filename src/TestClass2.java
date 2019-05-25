import java.io.IOException;
import java.io.InputStream;
class TestClass2 {
	
	public static void main (String[] args) throws IOException {
		int i;
		Scan s = new Scan();
		int n = (int) s.scanInt(), k = (int) s.scanInt();
		Long[] list = new Long[n + 1];
		for (i = 1; i <= n; i++)
			list[i] = s.scanInt();
		int l = (n + 1) / 2;
		int r = l;
		
		boolean odd = n % 2 != 0, klen = (k % 2 != 0);
		
		if (klen && odd) {
			l -= (k + 1) / 2;
			r += k - ((k + 1) / 2);
		} else if (klen) {
			r += (k + 1) / 2;
			l -= k - ((k + 1) / 2);
		} else {
			r += (k / 2);
			l -= (k / 2);
		}
//		for (i = 1; i <= k; i++) {
//			if ((i % 2 != 0) ^ odd)
//				r++;
//			else
//				l--;
//		}
		Long max = 0L;
		for (i = l; i <= r; i++) {
			max = (max > list[i]) ? max : list[i];
		}
		System.out.println(max);
	}
	
	static class Scan {
		private byte[] buf = new byte[10000];
		private int index;
		private InputStream in;
		private int total;
		
		Scan () {
			in = System.in;
		}
		
		long scan () throws IOException {
			if (index >= total) {
				index = 0;
				total = in.read(buf);
				if (total <= 0)
					return -1;
			}
			return buf[index++];
		}
		
		long scanInt () throws IOException {
			long integer = 0;
			long n = scan();
			while (isWhiteSpace(n))
				n = scan();
			while (!isWhiteSpace(n)) {
				integer *= 10;
				integer += n - '0';
				n = scan();
			}
			return integer;
		}
		
		private boolean isWhiteSpace (long n) {
			return n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1;
		}
	}
}