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
  ok();
   //freopen("in.txt","r",stdin);
   //freopen("out.txt","w",stdout);
   string n,n2="";
   set<string> res;
   while(cin>>n)
   {
      n2="";
      for(char x: n)
         if(tolower(x)>='a'&&tolower(x)<='z')
         {
            n2+=tolower(x);

         }
         else if(n2.size()){
            res.insert(n2);
            n2="";
         }
         if(n2.size()>0)
         res.insert(n2);

   }
   for(string x: res)
       //  if(x!=" "&&x)
         cout<<x<<endl;






      return 0;
}

