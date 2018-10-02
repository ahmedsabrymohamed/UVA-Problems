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
	int t,n,p,q,c=0;
	cin>>t;
	while(t--){
		c++;
		cin>>n>>p>>q;
		int x[n];
		for(int i=0;i<n;i++){
			cin>>x[i];
		}
		sort(x,x+n);
		int qt=0,pt=0;
		while(qt+x[pt]<=q&&pt+1<=p){
			qt+=x[pt++];
		}
		cout<<"Case "<<c<<": "<<pt<<endl;
	}

    return 0;
	
}


