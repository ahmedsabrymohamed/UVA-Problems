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
	string s,t;
	while(cin>>s>>t){
		int i=0,j=0;
		for(auto x:t){
			if(x==s[i])
				i++;
		}
		
		cout<<((i==s.size())?"Yes":"No")<<endl;
	}

		
    

    return 0;
	
}


