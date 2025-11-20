N = 100000;
p = 1/2;
p1=0;
p2=0;
p0=0;
for i = 1 : N
  for j= 1 : 3
    x(j)= rand < p;
   end;
  nr_true=sum(x);
if(nr_true==1)
    p1=p1+1;
  end;
if(nr_true==2)
    p2=p2+1;
  end;
if(nr_true==0)
    p0=p0+1;
  end;
end;

approx_p0=p0/N
approx_p1=p1/N
approx_p2=p2/N

fprintf("%f",approx_p0)
fprintf("\n")
fprintf("%f",approx_p1)
fprintf("\n")
fprintf("%f",approx_p2)
fprintf("\n")
