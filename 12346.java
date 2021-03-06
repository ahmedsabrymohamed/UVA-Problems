package cp;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.util.Pair;

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

	static boolean o[];
	static long x[][];
	static long min;

	static void sol(long w, long h, int indx) {

		for (int i = 0; i < 2; i++) {
			o[indx] = (i == 0 ? false : true);
			if (indx == o.length - 1) {

				long csum = 0, wsum = 0;
				for (int j = 0; j < o.length; j++) {
					if (o[j]) {
						csum += x[j][1];
						wsum += h * x[j][0];
					}
				}
				if (w <= wsum) {
					min = Math.min(min, csum);
				}
				if (i == 1)
					return;
			} else {
				sol(w, h, indx + 1);
			}

		}

	}

	static void input() throws IOException {

		Reader s = new Reader();
		int n = s.nextInt();
		x = new long[n][2];

		for (int i = 0; i < n; i++) {
			x[i][0] = s.nextLong();
			x[i][1] = s.nextLong();
		}
		int m = s.nextInt();

		for (int i = 0; i < m; i++) {
			min = Long.MAX_VALUE;
			o = new boolean[n];
			sol(s.nextLong(), s.nextLong(), 0);
			if (min == Long.MAX_VALUE) {
				System.out.println("Case " + (i + 1) + ": " + "IMPOSSIBLE");
			} else {
				System.out.println("Case " + (i + 1) + ": " + min);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		input();

	}

}