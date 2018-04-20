#include<bits/stdc++.h>
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
  ok();
   //freopen("in.txt","r",stdin);
   //freopen("out.txt","w",stdout);

  int res=0,n;

  while(cin>>n){
      bool sb=true,qb=true,pqb=true;
      stack<int> s;
      queue<int> q;
  priority_queue<int> pq;
   while(n--)
   {
      int x,y;

      cin>>x>>y;
      if(x==1)
      {
         s.push(y);
         q.push(y);
         pq.push(y);
      }
      else{
         if(s.size()<1||s.top()!=y)
               sb=0;
         if(s.size()>0)
         s.pop();
         if(q.size()<1||q.front()!=y)
               {
                  qb=0;
                 // cout<<q.front()<<" "<<y<<endl;;
               }
        if(q.size()>0)
         q.pop();
         if(pq.size()<1||pq.top()!=y)
               pqb=0;
         if(pq.size()>0)
         pq.pop();
      }
   }
   //cout<<pqb<<" "<<qb<<" "<<sb<<endl;;
   int a=0,b=0;
   if(pqb)
   {
      a++;
      b=1;
   }
   if(qb)
   {
      a++;
      b=2;
   }
   if(sb)
   {
      a++;
      b=3;
   }
   if(a>1)
      cout<<"not sure"<<endl;
   else if(a==0)
      cout<<"impossible"<<endl;
   else{

    if(b==1)
      cout<<"priority queue"<<endl;
   else if(b==2)
      cout<<"queue"<<endl;
   else if(b==3)
      cout<<"stack"<<endl;
   }

  }


      return 0;
}

