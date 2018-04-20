#include<bits/stdc++.h>
using namespace std;
void ok()
{
	ios::sync_with_stdio(0);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

void view(queue<int> m[]){
   for(int i=0;i<5;i++){
      while(!m[i].empty())
         {
            cout<<m[i].front()<<" ";
            m[i].pop();
         }
      cout<<endl;
   }
}

int main()
{
  ok();
  // freopen("in.txt","r",stdin);
  // freopen("out.txt","w",stdout);
  unordered_map<string ,int>alpha;
  int c=1;
  string s="";


 for(int x=0;x<5;x++)
   {
      for(int i=0;i<26;i++)
      {
         if(x==0)
         alpha[(s+char('a'+i))]=c++,s="";
         if(x)
         for(int j=i+1;j<26;j++)
         {
            if(x==1)
            alpha[(s+char('a'+i))+char('a'+j)]=c++,s="";
            if(x>1)
            for(int k=j+1;k<26;k++)
            {
               if(x==2)
               alpha[(s+char('a'+i))+char('a'+j)+char('a'+k)]=c++,s="";
               if(x>2)
               for(int l=k+1;l<26;l++)
               {
                  if(x==3)
                     alpha[(s+char('a'+i))+char('a'+j)+char('a'+k)+char('a'+l)]=c++,s="";
                  if(x==4)
                     for(int m=l+1;m<26;m++)
                     alpha[(s+char('a'+i))+char('a'+j)+char('a'+k)+char('a'+l)+char('a'+m)]=c++,s="";



               }
            }
         }

      }

   }
while(cin>>s)
   cout<<alpha[s]<<endl;


      return 0;
}

