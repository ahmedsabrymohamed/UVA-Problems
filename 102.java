package cp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.Arrays;
import java.util.Collections;


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
	//BGC
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Reader s=new Reader();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder up=new StringBuilder("xxx"); 
		StringBuilder up2=new StringBuilder("xxx"); 
		
		
		String x;
		while ((x= br.readLine())!=null) {
			
			String[] integersInString;
			int c=-1,g=-1,b=-1,i2=0;
			integersInString=x.split(" ");
			long t=Long.MAX_VALUE;
			int boxs[][]=new int[3][3];
			for(int j=0;j<3;j++)
			for(int i=0;i<3;i++)
			{
				boxs[j][i]=Integer.parseInt(integersInString[i2]);
				i2++;
			}
			
			for(int i=0;i<3;i++) {
				
				b=boxs[i][0];
				
				for(int j=0;j<3;j++) {
					if(i==j)continue;
					g=boxs[j][1];
					
					
					for(int k=0;k<3;k++) {
						long t2=0;
						if(k==j||k==i)continue;
						
						c=boxs[k][2];
						t2+=boxs[0][2]+boxs[1][2]+boxs[2][2]-c;
						t2+=boxs[0][0]+boxs[1][0]+boxs[2][0]-b;
						t2+=boxs[0][1]+boxs[1][1]+boxs[2][1]-g;
						
						up2.setCharAt(i, 'B');
						up2.setCharAt(j, 'G');
						up2.setCharAt(k, 'C');
					
						if(t2<t) {
							t=t2;
							up.replace(0, up.length(), up2.toString());
						}
						else if(t2==t) {
							t=t2;
							int compare = up.toString().compareToIgnoreCase(up2.toString());
							if(compare > 0 ){
							
								up.replace(0, up.length(), up2.toString());
							}
							
							
						}
						
					
					}
				}
			}
			System.out.println(up+" "+t);
		
		}
		
	}

}
