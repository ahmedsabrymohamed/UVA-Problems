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



   long s;

   while(cin>>s)
   {


      if(s){
         deque<long>v;
         long i=0;
         for(int i=1;i<=s;i++)
            v.push_back(i);
         cout<<"Discarded cards:";
         while(v.size()>1)
         {

            cout<<" "<<v.front();

            v.pop_front();
            v.push_back(v.front());
            v.pop_front();
            if(v.size()>1)
               cout<<",";
         }
         cout<<"\nRemaining card: "<<v.front()<<endl;



      }




   }




   return 0;
}
