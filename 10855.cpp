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
//this function was wrong so I used r90 to rotate the square m90 to m180
//and the best solution is to use r90 to rotate the square 90-->180-->270 and check it :)

/*
void r180(string *m,int e){

   int s=0;
   while(s<=e){
      swap(m[s],m[e]);
      reverse(m[s].begin(),m[s].end());
      reverse(m[e].begin(),m[e].end());
      s++;
      e--;
   }

}
*/
void r90(string *m,string *mr,long ns){

   int ir;
   for(int i=0;i<ns;i++)
   for(int i2=0;i2<ns;i2++){
      
      mr[i][i2]=m[ns-1-i2][i];

   }


}
void r270(string *m,string *mr,long ns){

   for(int i=0;i<ns;i++)
   for(int i2=0;i2<ns;i2++){
      mr[ns-1-i2][i]=m[i][i2];
   }


}
void check(string *mb,string *ms,long cs,long ce,long rs,long re,long &con){

   long i,i2;
   loop(i,rs,re)
      loop(i2,cs,ce)
      {
         if(mb[i][i2]!=ms[i-rs][i2-cs])
         return;

      }
      con++;
}

int main()
{

 //freopen ("out.txt","w",stdout);
 //freopen ("in.txt","r",stdin);

   moon7
   long nb,ns;
   while(1)
      {
         cin>>nb>>ns;
         if(nb&&ns){

         string mb[nb],ms[ns],ms90[ns],ms270[ns],ms180[ns];
            long i,i2;
         loop(i,0,nb)
            cin>>mb[i];
         loop(i2,0,ns)
         {
            cin>>ms[i2];
            ms180[i2]=ms[i2];
            ms90[i2]=ms[i2];
            ms270[i2]=ms[i2];
         }

       r90(ms,ms90,ns);
       r90(ms90,ms180,ns);
       r270(ms,ms270,ns);
         long con1=0,con2=0,con3=0,con4=0;
         loop(i,0,nb)
            loop(i2,0,nb)
            if(i+ns-1<nb&&i2+ns-1<nb)
            {
               check(mb,ms,i2,i2+ns,i,i+ns,con1);
               check(mb,ms90,i2,i2+ns,i,i+ns,con2);
               check(mb,ms180,i2,i2+ns,i,i+ns,con3);
               check(mb,ms270,i2,i2+ns,i,i+ns,con4);
            }
            cout<<con1<<" "<<con2<<" "<<con3<<" "<<con4<<endl;

       }
         else
           break;

   }




   return 0;
}
