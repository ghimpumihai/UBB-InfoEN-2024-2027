N=1e5;
res=0;
for i= 1 : N
  U=randperm(50);
  ok=1;
  for j= 1 : 50
    if(j==U(j))
      ok=0;
     end;
  end;
  if(ok==1)
  res=res+1;
  end;
end;
ap1=res/N
fprintf("%f",ap1)
