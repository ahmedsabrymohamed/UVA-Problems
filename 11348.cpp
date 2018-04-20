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

   int t,con2=1;
   cin>>t;

   while(t--)
   {
      int n;
      cin>>n;
      map<double,set<double> >sm;
      map<double,double >res;
      double sum=0;
      double con=0;
      while(n--)
      {
         int m;
         cin>>m;
         while(m--)
         {
            int a;
            cin>>a;
            sm[a].insert(con);
         }
         con++;
      }
      cout<<"Case "<<con2<<": ";
      cout<<fixed<<setprecision(6);
      for(auto x:sm)
      if(x.second.size()==1)
         res[*x.second.begin()]++,sum++;
      for(int i=0;i<con;i++)
         if(i+1==con)
         cout<<(res[i]*100)/sum<<"%";
         else
         cout<<(res[i]*100)/sum<<"% ";
      con2++;
      cout<<endl;
   }
   return 0;

}
