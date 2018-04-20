#include<bits/stdc++.h>
using namespace std;
void ok()
{
	ios::sync_with_stdio(0);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

int main(){

   //freopen("in.txt","r",stdin);
   //freopen("out.txt","w",stdout);

   int t;
   cin>>t;

   while(t--)
   {
      string o,n,k="",v="";
      map<string,pair<int,string> >m;
      set<string> res[3];

      cin>>o;

      for(char x:o)
         if(x>='a'&&x<='z')
         k+=x;
         else if(x>='0'&&x<='9')
         v+=x;
         else if(x==','||x=='}')
         {

            m[k].first=2;
            m[k].second=v;
            v=k="";
         }

      cin>>n;
      for(char x:n)
         if(x>='a'&&x<='z')
         k+=x;
         else if(x>='0'&&x<='9')
         v+=x;
         else if(x==','||x=='}')
         {


            if(m.find(k)!=m.end())
            {
               if(m[k].second!=v)
               m[k].first=3;
               else
               m[k].first=4;
            }
            else
               m[k].first=1;

            v=k="";

         }
      for(auto x:m)
         if(x.second.first<4&&x.first!="")
         res[x.second.first-1].insert(x.first);
      bool t=1;
      for(int i=0;i<3;i++)
      {
         if(res[i].size())
         {
            t=0;
            if(i==0)
               cout<<"+";
            else if(i==1)
               cout<<"-";
            else
               cout<<"*";
            int con=0;
            for(auto x: res[i])
               if(con+1==res[i].size())
               cout<<x;
               else
               cout<<x<<',',con++;
            cout<<endl;
         }
         res[i].clear();
      }
      if(t)
         cout<<"No changes"<<endl;


       cout<<endl;

   }
   return 0;

}
