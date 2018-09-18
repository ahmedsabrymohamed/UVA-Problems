package cp;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.BitSet;




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



	public static void swap(long[] a,int i, int j)
	{
	      long temp = a[i];
	      a[i] = a[j];
	      a[j] = temp;
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
	static void display(int x[][][],int n) {
		for(int i=0;i<n;i++) {
			System.out.println();
			for(int j=0;j<8;j++) {
				System.out.println();
				for(int k=0;k<8;k++)
					System.out.print(x[i][j][k]+" ");
			}
		}
		
	}
	static void sol(int x[][][],int n,BitSet rd,BitSet ld,BitSet rw,int c,int sum,int []max) {
		if(c==8) {
			max[n]=Math.max(max[n], sum);
			return ;
		}
		for(int i=0 ;i<8;i++)
		{
			if(!rw.get(i)&&!ld.get(i-c+7)&&!rd.get(i+c)) {
				rw.set(i, true);ld.set(i-c+7,true);rd.set(i+c,true);
				sol(x,n,rd,ld,rw,c+1,sum+x[n][i][c],max);
				rw.set(i, false);ld.set(i-c+7,false);rd.set(i+c,false);
			}
		}
		
		
	
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader s=new Reader();
		int n=s.nextInt();
		int x[][][]=new int [n][8][8];
		for(int i=0;i<n;i++)
			for(int j=0;j<8;j++)
				for(int k=0;k<8;k++)
					x[i][j][k]=s.nextInt();
		
		BitSet rd,ld,rw;
		rd=new BitSet(15);
		ld=new BitSet(15);
		rw=new BitSet(8);
		int max[]=new int[n];
		
		for(int i=0;i<n;i++) {
			max[i]=0;
			sol(x,i,rd,ld,rw,0,0,max);
			if (max[i] < 10)
				System.out.println("    " + max[i]);
			else if (max[i] < 100)
				System.out.println("   " + max[i]);
			else
				System.out.println( "  "+ max[i]);

		}
		
		
		
		
		
	}

}