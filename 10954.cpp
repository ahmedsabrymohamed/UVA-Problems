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
   int n;
   while(1){
      cin>>n;
      if(!n)
         break;
      priority_queue<long> a;
      int d;
      for(int i=0;i<n;i++)
         {
            cin>>d;
            a.push(-d);
         }



         long res=-(a.top()),res2=0;
         a.pop();
      while(!a.empty())
      {
         res-=a.top();
         a.pop();
         res2+=res;
         a.push(-res);
         res=0;
         res-=a.top();
         a.pop();
      }

      cout<<res2<<endl;
   }





      return 0;
}

