#include<string>
#include<iostream>
#include<queue>
#include<math.h>
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
   //freopen("in.txt","r",stdin);
   //freopen("out.txt","w",stdout);


 //  ok();
  long n,con=0;
  while(cin>>n)
   {
      con++;

      if(!n)
         break;



       queue<long> teams[n];
       queue<long> pops;
       int nums[1000000];
       for(int i=0;i<n;i++)
       {
          int x;
          cin>>x;
          for(int j=0;j<x;j++)
          {
             int a;
             cin>>a;
             nums[a]=i;
          }
       }
       cout<<"Scenario #"<<con<<endl;;
       string order;
       while(1){
         cin>>order;

         if(order=="STOP")
            break;
         if(order=="DEQUEUE")
         {
            long index=pops.front();
            cout<<teams[index].front()<<endl;
            teams[index].pop();
            if(teams[index].size()==0)
               pops.pop();
         }
         else{

               long tmember;
               cin>>tmember;

               if(teams[nums[tmember]].size()==0)
                  pops.push(nums[tmember]);

               teams[nums[tmember]].push(tmember);
            }
       }


      cout<<endl;

   }


    return 0;
}

