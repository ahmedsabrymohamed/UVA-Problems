#include<bits/stdc++.h>
using namespace std;
void ok()
{
	ios::sync_with_stdio(0);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}
long sol(long* m,int size,int n){

   long tm[size+5]={0};
   for(int i=0;i<size;i++){


      for(int j=0;j<n;j++){

         tm[i]+=m[(i^(1<<j))];
 
      }
    
   }
  long    res=-1;
   for(int i=0;i<size;i++){

      for(int j=0;j<n;j++){

         res=max(tm[i]+tm[(i^(1<<j))],res);
    
      }
   }
   return res;
}
int main()
{
   //freopen("in.txt","r",stdin);
   //freopen("out.txt","w",stdout);
   ok();
   int n;
   while(cin>>n){

      long size=pow(2,n);
      long m[size+5];
      for(int i=0;i<size;i++)
      {
         cin>>m[i];
      }
     cout<< sol(m,size,n)<<endl;
   }
    return 0;
}

