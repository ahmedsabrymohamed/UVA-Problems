package cp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static class Reader {
		final private int BUFFER_SIZE = 1 << 20;
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
			byte[] buf = new byte[1024]; // line length
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

	static String x[];
	static int min = Integer.MAX_VALUE;
	static int mini = -1;

	static void sol(StringBuilder a, int si, int ei, int indx) {
		//System.out.println(si+"  "+ei);
		if(ei==x[indx].length())
			return;
		int t = 0;
		for (int i = si, j = 0; i <= ei; i++, j++) {
			if (a.charAt(j) != x[indx].charAt(i)) {
				t++;
			}
		}
		
		if (t < min) {
			mini = indx+1;
			min = t;
		}
		sol(a, si + 1, ei+ 1, indx);
		
	}

	static void input() throws IOException {

		Reader s = new Reader();
		int m = s.nextInt(), q = s.nextInt();
		
		x = new String[m];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < m; i++) {
			x[i] = s.readLine();
			
			
			
		}

		for (int i = 0; i < q; i++) {
			StringBuilder a = new StringBuilder(s.readLine());
			min=Integer.MAX_VALUE;
			mini=-1;
			
			for (int j = 0; j < m; j++) {
				if(x[j].length()>=a.length())
				sol(a, 0, a.length()-1, j);
			}
			System.out.println(mini);
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		input();
		

	}

}
