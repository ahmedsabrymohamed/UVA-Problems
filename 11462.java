//package cp;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.Math;


class Main {

	static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
	public static int merge(int a[],int p,int q,int r) {
		int s=0;
		int n1=q-p+1;
		int n2 =r-q;
		int[] le=new int[n1+1];
		int[] ri=new int[n2+1];
		ri[n2]=le[n1]=Integer.MAX_VALUE;
		
		for(int i=0;i<n1;i++)
			le[i]=a[i+p];
		for(int i=0;i<n2;i++)
			ri[i]=a[i+q+1];
		int i,j;
		i=j=0;
		for (int k=p;k<=r;k++) {
			//System.out.println("k"+k);
			if(le[i]<=ri[j]){
				a[k]=le[i];
				i++;
			}
			else {
				a[k]=ri[j];
				s+=n1-i;
			//	System.out.println("S: "+s+" "+i+" "+q);
				j++;
			}
				
		}
		
		return s;
	}
	public static int sort(int a[],int p,int r) {
		int s=0;
		if (p<r) {
			int q=(p+r)/2;
			s+=sort(a,p,q);
			s+=sort(a,q+1,r);
			s+=merge(a,p,q,r);
		}
		return s;
	}
	public static long[] cSort(long x[],int a) {
		int in=1;
		int temp[]=new int[10];
		long res[]=new long [x.length];
		for(;a-->0;in*=10);
		for(long n:x)
			temp[(int)n%in/(in/10)]++;
		
		for(int i=1;i<10;i++)
			temp[i]+=temp[i-1];
		
		
		for(int i=x.length-1;i>-1;i--) {
			res[temp[(int)x[i]%in/(in/10)]-1]=x[i];
			temp[(int)x[i]%in/(in/10)]--;
		}
		
			
		return res;
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader s=new Reader();
		while(true) {
			int n=s.nextInt();
			if(n==0)break;
			long a[]=new long[n];
			long max=0;
			for(int i=0;i<n;i++) {
				a[i]=s.nextLong();
				max=Math.max(a[i], max);
			}
			String maxs=Long.toString(max);
			for(int i=0;i<maxs.length();i++)
				a=cSort(a,i+1);
			for(int i=0;i<a.length;i++)
				System.out.print(a[i]);
			System.out.println();
			
		}
	}

}
