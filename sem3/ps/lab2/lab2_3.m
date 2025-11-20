N=1e2;
n2_after1=0;
n1_next2=0;
for i= 1 : N
  U=randperm(5);
  for i = 1 : 4
    if(U(i)==1 && U(i+1)==2)
      n1_next2=n1_next2+1;
    end;
    if(U(i)==2 && U(i+1)==1)
      n1_next2=n1_next2+1;
    end;
    if(U(i)==2 && U(i+1)==1)
      n2_after1=n2_after1+1;
    end;
  end;
end;
ap1=n1_next2/N
ap2=n2_after1/N

fprintf("%f",ap1)
fprintf("\n")
fprintf("%f",ap2)
