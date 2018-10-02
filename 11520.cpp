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
	for(int i=0;i<t;i++){

		int n;
		cin>>n;
		char x[n+2][n+2];
		

		for(int j=0;j<=n+2;j++)
			for(int k=0;k<=n+2;k++)x[j][k]='F';
		for(int j=1;j<=n;j++)
			for(int k=1;k<=n;k++){
				cin>>x[j][k];
			}
		for(int j=1;j<=n;j++)
			for(int k=1;k<=n;k++){
				if(x[j][k]!='.')continue;
				int y[28]={0};
				
				if(x[j+1][k]!='.')
					{
						y[x[j+1][k]-'A']=1;	
					}
				if(x[j-1][k]!='.')
					{
						y[x[j-1][k]-'A']=1;
					}
				if(x[j][k+1]!='.')
					{
						y[x[j][k+1]-'A']=1;
					}
				
				if(x[j][k-1]!='.')
					{
						y[x[j][k-1]-'A']=1;
					}
				for(int l=0;l<28;l++)
				{
					if(!y[l])
						{x[j][k]=l+'A';break;}
				}

			}

		cout<<"Case "<<i+1<<":\n";
		for(int j=1;j<=n;j++){
			for(int k=1;k<=n;k++){
				cout<<x[j][k];
			}
			cout<<endl;

		}
	}
    return 0;
	
}


