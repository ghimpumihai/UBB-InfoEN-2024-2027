pkg load statistics

fprintf("%0.6f\n",geopdf(4,0.3));
fprintf("%0.6f\n",geocdf(3,0.3));

N=100000;

p=0.3;
nr1=0;
nr2=0;
for i= 1 : N
  ok1=1;
  ok2=0;
  for j= 1 : 5
    x(j)= rand < p;
   endfor;
  for j= 1 : 4
    if(x(j)==1)
    ok1=0;
    endif;
   endfor;
   if(x(5)==0)
   ok1=0;
   endif;
  for j= 1 : 4
    y(j)= rand < p;
   endfor;
   for j= 1 : 4
     if(y(j)==1)
      ok2=1;
      endif;
   endfor;
   if(ok1==1)
   nr1=nr1+1;
   endif;
   if(ok2==1)
   nr2=nr2+1;
   endif;
endfor;
prob1=nr1/N
prob2=nr2/N
