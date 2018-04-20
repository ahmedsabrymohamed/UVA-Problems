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

   long n;
   cin>>n;
   map<string,int > m;
   while(n){
      m.clear();
   set<int> se;
   int s;
   while(n--)
      {
         se.clear();
         for(int i=0;i<5;i++)
         cin>>s,se.insert(s);
         string res="";
         for(int x:se)
            res+=to_string(x);
         m[res]++;
      }
   int max1=-1;
   for(auto x: m)
      max1=max(max1,x.second);
   int re=0;
   for(auto x: m)
      if(max1==x.second)
      re+=max1;
   cout<<re<<endl;


   cin>>n;


   }
   return 0;

}
