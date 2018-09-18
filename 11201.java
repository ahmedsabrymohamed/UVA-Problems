package cp;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}

			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

	public static void swap(long[] a, int i, int j) {
		long temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void display(int x[][]) {
		for (int i = 0; i < 1025; i++) {
			for (int j = 0; j < 1025; j++) {
				System.out.println(x[i][j]);
			}
		}

	}

	static double x[] = { 12.53, 1.42, 4.68, 5.86, 13.68, 0.69, 1.01, 0.70, 6.25, 0.44, 0, 4.97, 3.15, 6.71, 8.68, 2.51,
			0.88, 6.87, 7.98, 4.63, 3.93, 0.90, 0.02, 0.22, 0.9, 0.52 };
	static byte c[];
	static int size = 0;
	static double sum = 0, counter = 0;
	static StringBuilder wi;
	static char chars[] = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w',
			'x', 'y', 'z' };
	static char v[] = { 'a', 'e', 'i', 'o', 'u' };

	static void sol() {
		if (wi.length() == size) {
			sum += csbc(wi.toString());
			counter++;
			c[wi.charAt(wi.length() - 1) - 'a']--;
			wi.deleteCharAt(wi.length() - 1);
			return;
		}
		if (wi.length() % 2 != 0) {
			for (int i = 0; i < v.length; i++)
				if (c[v[i] - 'a'] < 2) {
					c[v[i] - 'a']++;
					wi.append(v[i]);
					sol();
				}

		} else {
			for (int i = 0; i < chars.length; i++)
				if (c[chars[i] - 'a'] < 2) {
					c[chars[i] - 'a']++;
					wi.append(chars[i]);
					sol();
				}
		}
		if (wi.length() > 0) {
			c[wi.charAt(wi.length() - 1) - 'a']--;
			wi.deleteCharAt(wi.length() - 1);
		}

	}

	static double csbc(String w) {
		double sbc = 0;
		for (int j = 0; j < size; j++) {
			sbc += ((j + 1) * x[w.charAt(j) - 'a']);
		}
		return sbc;
	}

	static void input() throws IOException {

		Reader s = new Reader();
		int n = s.nextInt();

		for (int i = 0; i < n; i++) {
			String word = s.readLine();
			size = word.length();
			sum = 0;
			counter = 0;
			wi = new StringBuilder();
			wi.append(word.charAt(0));
			c = new byte[26];
			double sbc = csbc(word);
			sol();
			if ((sum / counter) > sbc)
				System.out.println("below");
			else
				System.out.println("above or equal");

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		input();

	}

}
