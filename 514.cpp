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



   long s,t=0;

   while(cin>>s)
   {


      if(s){


        while(1)
            {


            queue<long>a;
            stack<long>b;

            for(long i=1;i<=s;i++)
              {
                 a.push(i);

              }


            //con is the test for the test case result
            //r is the test if the input (c) is zero
            //c is the input of the permutation
            long c,r=0,con=1;



           for(int i=0;i<s;i++)
           {
               cin>>c;


               if(!c)
                  {
                     cout<<endl;
                     r=1;
                     break;
                  }

               if(!b.empty()&&b.top()==c)
                  b.pop();
               else
               {
                  while(a.front()!=c&&!a.empty())
                  {

                     b.push(a.front());

                     a.pop();
                  }

                  if(!a.empty()&&a.front()==c)
                     {

                        a.pop();
                     }
                  else {

                        con=0;
                  }
               }




           }

           if(!r)
           if(con)
            cout<<"Yes"<<endl;
           else
            cout<<"No"<<endl;

            if(r)
               break;

         }

      }




   }




   return 0;
}
