package cp;

import java.io.BufferedReader;
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



	
	static void input() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String line = input.readLine();
		while (line != null&&!line.equals("")) {
			String[] strs = line.trim().split("\\s+");
			// display(strs);
			int n = Integer.parseInt(strs[0]);
			int t = Integer.parseInt(strs[1]);
			int x[] = new int[t];
			for (int i = 0; i < t; i++) {
				x[i] = Integer.parseInt(strs[i + 2]);
			}
			ArrayList<Integer> res=new ArrayList<>();
			int max;
			max=sol(x, n, 0,0,-1,res,new ArrayList<Integer>());
			for(int i:res)
				System.out.print(i+" ");
			System.out.println("sum:"+max);
			//display(x);
			line = input.readLine();
		}
	}
	static int sol(int x[],int n,int sum,int indx,int max,ArrayList res,ArrayList<Integer> temp) {
		if (sum <= n) {
			
			if(sum>max) {
				max=sum;
				res.clear();
				
				for(Integer i:temp)
					res.add(i);
			}
			
			
		}
		for(int i=indx;i<x.length;i++) {
			if(x[i]+sum<=n) {
				temp.add(x[i]);
				max=sol(x,n,sum+x[i],i+1,max,res,temp);
			}
		}
		if(!temp.isEmpty())
		{
			//System.out.println(res.size());
			sum -= x[indx-1];
			temp.remove(temp.size()-1);
		}
		return max;
		
		

	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader s = new Reader();
		input();
		System.out.println();
		
		
		
		
		
	}

}