p = 1/6;
N = 1e3;
nr=0;
for i = 1 : N
  for j= 1 : 25
    U(j) = randi(6);
  end;
  nr_2=0;
  for j= 1 : 25
  if(U(j)==6)
    nr_2=nr_2+1;
   end;
  end;
  if(nr_2>=10)
    nr=nr+1;
  end;
end;

approx_nr=nr/N

fprintf("%f",approx_nr)
