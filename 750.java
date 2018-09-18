package cp;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;

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

	static ArrayList<String> x=new ArrayList<>();
	static BitSet rw, ld, rd;
	static int ri, ci;

	static void sol(int c, StringBuilder a) {
		if (c == 8) {
			x.add(a.toString());
			return;
		}
		if (c == ci) {
			sol(ci + 1, a);

		} else {
			for (int i = 0; i < 8; i++) {
				if (!rw.get(i) && !ld.get(i - c+7) && !rd.get(i+c)) {
					rw.set(i, true);
					rd.set(i + c, true);
					ld.set(i - c + 7, true);
					a.setCharAt(c, (char) ('0' + i+1));
					sol(c + 1, a);
					rw.set(i, false);
					rd.set(i + c, false);
					ld.set(i - c + 7, false);
				}

			}
		}

	}

	static void input() throws IOException {

		Reader s = new Reader();
		rw = new BitSet(8);
		ld = new BitSet(15);
		rd = new BitSet(15);
		int t = s.nextInt();
		
		for (int i = 0; i < t; i++) {
			
			StringBuilder a = new StringBuilder("00000000");
			ri = s.nextInt() - 1;
			ci = s.nextInt() - 1;
			a.setCharAt(ci, (char) ('0' + ri+1));
			rw.set(ri, true);
			rd.set(ri + ci, true);
			ld.set(ri - ci + 7, true);
			sol(0, a);
			Collections.sort(x);
			System.out.println("SOLN       COLUMN\n" + " #      1 2 3 4 5 6 7 8\n" );
			for(int j=0;j<x.size();j++) {
				System.out.print((j+1<10?" "+(j+1):(j+1))+"     ");
				for(char c:x.get(j).toCharArray()) {
					System.out.print(" ");
					System.out.print(c);
					
				}
				System.out.println();
				
			}
			if(i<t-1)
			System.out.println();
			rw.clear();
			rd.clear();
			ld.clear();
			x.clear();
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		input();

	}

}
