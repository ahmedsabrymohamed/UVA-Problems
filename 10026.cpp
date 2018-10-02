#include <bits/stdc++.h>
#define ll long long
#define ld long double 
using namespace std;
void ok()
{
	ios::sync_with_stdio(0);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}


int main()
{
	//freopen ("in","r",stdin);
	//freopen ("out","w",stdout);
	ok();
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		long x[n][2];
		for(int i=0;i<n;i++)
			cin>>x[i][0]>>x[i][1];
		long indx=0,time=0;
		bool f[n]={0};
		
		for(int i=0;i<n;i++)
		{
			indx=0;
			while(f[indx])indx++;

			for(int j=0;j<n;j++)
			{
				if(f[j])
					continue;
				if(indx!=j&&((x[indx][0]+time)*x[j][1])>(x[indx][1]*(time+x[j][0])))
					indx=j;
			}
			cout<<indx+1;
			f[indx]=1;
			if(i+1!=n)
				cout<<" ";
			
		}
				if(t)
				cout<<endl;
				cout<<endl;
		
		


	}
    return 0;
	
}


