#include<bits/stdc++.h>
using namespace std;
void ok()
{
	ios::sync_with_stdio(0);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}


long sol(int n,int s,int q){
   queue<int> st[n];
   stack<int> carry;
   int y,sum=0;
   int bq;
   for(int i=0;i<n;i++)
   {

      cin>>bq;
      //st[i]=new queue<int> ();
      sum+=bq;
      for(int j=0;j<bq;j++)
      {
         cin>>y;
         st[i].push(y);

      }

   }
   int res=0,i=0;
   while(sum!=0){

      while(!carry.empty()){

         if(carry.top()==(i+1))
         res++,carry.pop(),sum--;
         else if(st[i].size()<q)
               res++,st[i].push(carry.top()),carry.pop();
         else
            break;

      }
     if(sum==0)
         return res;
      while(carry.size()<s&&st[i].size())
         carry.push(st[i].front())
         ,st[i].pop(),res++;

      res+=2;
      i++;
      i%=n;
   }

         return res;



}
int main()
{
  ok();

  int num,n,s,q;
   cin>>num;
   while(num--){
      cin>>n>>s>>q;
      cout<<sol(n,s,q)<<endl;
   }
    return 0;
}

