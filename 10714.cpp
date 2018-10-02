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
	long l,n,t;
	cin>>t;
	while(t--){
		cin>>l>>n;
		long x,maxl=0,minl=0;
		
		for(int i=0;i<n;i++)
			{
				cin>>x;
				
				minl=max(minl,min(x,l-x));
				maxl=max(maxl,max(x,l-x));
				
			}
			
		cout<<minl<<" "<<maxl<<endl;
	}
    return 0;
	
}


