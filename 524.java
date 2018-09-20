package cp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;




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



	
	static boolean prime(int n)
	{
	    if (n <= 1)  return false;
	    if (n <= 3)  return true;
	    if (n%2 == 0 || n%3 == 0) return false;
	 
	    for (int i=5; i*i<=n; i=i+6)
	        if (n%i == 0 || n%(i+2) == 0)
	           return false;
	 
	    return true;
	}
	static boolean pr[]=new boolean[101];
	static  BufferedWriter writer;
	static void sol(ArrayList<ArrayList<Integer> > a,ArrayList<Integer> b,boolean[]u,int l,int n) throws IOException {
		if (b.size() == n) {
			if (pr[l + 1]) {
				ArrayList<Integer> t = new ArrayList();
				int q=0;
				for(;q<b.size()-1;q++) {
					t.add(b.get(q));
					System.out.print(b.get(q) + " ");
					
				}
				
				System.out.print(b.get(q));
				System.out.println();
				a.add(t);
			}

		}
		else {
			for(int i=1;i<=n;i++)
				if(!u[i]&&pr[l+i]) {
					b.add(i);
					u[i]=true;
					sol(a,b,u,i,n);
				}
		}
		b.remove(b.size()-1);
		u[l]=false;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i=1;i<101;i++)
			pr[i]=prime(i);
		int counter=1;
		
		while((str =br.readLine())!=null) {
			int n=Integer.parseInt(str);
			ArrayList<ArrayList<Integer> > a =new ArrayList();
			ArrayList<Integer> b=new ArrayList();
			boolean[] u=new boolean[17];
			b.add(1);
			u[1]=true;
			System.out.println("Case "+counter++ +":");
			sol(a,b,u,1,n);
			System.out.println();
			
			
			
		}
		
		
	}

}