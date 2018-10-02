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
	ok();
	int t,n,c=0;
	cin>>t;
	while(t--){
		c++;
		cin>>n;
		char x[n];
		for(int i=0;i<n;i++){
			cin>>x[i];
		}
		int sc=0;

		for(int i=0;i<n;)
		{	
			if(x[i]=='#'){i++;continue;};
			bool t1=0,t2=0,t3=0;
			t1=(i<n&&x[i]=='.');
			t2=(i+1<n&&x[i+1]=='.');
			t3=(i+2<n&&x[i+2]=='.');
			if(t1||t2||t3)
				sc++;
			i+=3;
		}
		cout<<"Case "<<c<<": "<<sc<<endl;
	}

    return 0;
	
}


