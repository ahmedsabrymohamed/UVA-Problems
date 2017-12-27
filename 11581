#include<bits/stdc++.h>
using namespace std;
void ok()
{
	ios::sync_with_stdio(0);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

int m[5][5];
int tm2[5][5];
int sol(int ones){
   int con=-1;
   while(ones){
      ones=0;
      con++;
       for(int i=0;i<3;i++)
      for(int j=0;j<3;j++){

         tm2[i+1][j+1]=(m[i+2][j+1]+m[i+1][j+2]+m[i][j+1]+m[i+1][j])%2;
         ones+=tm2[i+1][j+1];
      }
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++){

         m[i+1][j+1]=tm2[i+1][j+1];
      }
   }
   return con;
}


int main()
{
   //freopen("in.txt","r",stdin);
   //freopen("out.txt","w",stdout);
   ok();
   long long n;

    cin>>n;

   while(n--){

      char c;
      cin.ignore();
      int ones=0;
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++){
         cin>>c;
        
         ones+=(c-'0');
         m[i+1][j+1]=c-'0';
      }
      if(ones)
         cout<<sol(ones)<<endl;
      else
         cout<<-1<<endl;;
   }

    return 0;
}

