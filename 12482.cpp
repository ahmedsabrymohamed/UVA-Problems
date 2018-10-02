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
	long l,n,c;
	string s;
	while(cin>>n>>l>>c){
		cin.ignore();
		s="";
		getline(cin,s);
		int lt=0,ct=0,gt=0;
		while(ct<s.size()){
			
			if(s[ct]==' ')
			{
				ct++;

				continue;
			}

			while(ct>0&&s[ct-1]!=' ')
				{
					
					ct--;
				}

			
			ct+=c;
			lt++;
			if(lt==l){
				lt=0;
				gt++;
			}
		}
		gt+=lt>0;
		cout<<gt<<endl;
	}
    return 0;
	
}


