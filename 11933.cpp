#include<bits/stdc++.h>
using namespace std;
#define all(x) x.begin(),x.end()
#define ll long long
#define ull unsigned long long
#define ld long double
#define vll vector<long long>
#define vl vector<long>
#define vi vector<int>
#define  vs vector<string>
#define vld vector<long double>
#define pb  push_back
#define moon7	ios::sync_with_stdio(0);ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
#define loop(i,x,n) for(int i=x;i<n;i++)
#define loopn(i,x,n) for(int i=x;i>=n;i--)

int main()
{

 //freopen ("out.txt","w",stdout);
 //freopen ("in.txt","r",stdin);

   moon7
   ull s;
   while(cin>>s)
   {
      if(s){
         long i=0,a=0,b=0,con=0;
         loop(i,0,32)
         {
            bool t=s&(1<<i);
            if(t)
               con++;
            if(t&&con%2){
               a|=(1<<i);
            }
            else if(!(con%2)&&t){
               b|=(1<<i);
            }
         }
        
         cout<<a<<" "<<b<<endl;
      }

   }




   return 0;
}
