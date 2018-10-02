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
		ll n,d;cin>>n>>d;
		ll x[n+2][2];
		x[0][0]=0;
		x[0][1]=1;
		x[n+1][0]=d;
		x[n+1][1]=1;
		ll max1=-1;
		for(int j=1;j<=n;j++){
			char c,u;
			cin>>c>>u>>x[j][0];
			x[j][1]=(c=='B');
		}
		for(int j=0;j+1<n+2;j++){
			if(!x[j+1][1])
			{
				max1=max(max1,x[j+2][0]-x[j][0]);
				x[j][1]-=(!x[j][1]);
				x[j+2][1]-=(!x[j+2][1]);
				j++;
				
			}
			else
			{
				max1=max(max1,x[j+1][0]-x[j][0]);
				x[j][1]-=(!x[j][1]);
				
			}

		}
		
		int indx=0;
		for(int j=1;j<n+2;j++){
			if(x[j][1]>-1)
			{
				max1=max(max1,x[j][0]-x[indx][0]);
				indx=j;
			}
		}

		cout<<"Case "<<i+1<<": "<<max1<<"\n";
	}
    return 0;
	
}


