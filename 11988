#include<bits/stdc++.h>
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
   //freopen("in.txt","r",stdin);
   //freopen("out.txt","w",stdout);
   list<char>::iterator c;
   list<char> s;
   c=s.begin();
   ok();
   string n;
   while(cin>>n){

   for(auto x:n)
      {
         if(x=='[')
            {
               c=s.begin();
               continue;
            }
         else if(x==']')
            {
               c=s.end();
               continue;
            }


         s.insert(c,x);
      }
      for(auto x:s)
      cout<<x;
      cout<<endl;
      s.clear();
      c=s.begin();
   }

    return 0;
}

