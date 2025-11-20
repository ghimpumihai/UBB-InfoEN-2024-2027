pkg load statistics

fprintf("%.6f\n",binopdf(8,20,0.25))
fprintf("%.6f\n",binocdf(7,20,0.25))
fprintf("%.6f\n",1-binocdf(9,20,0.25))
fprintf("%.6f\n",1-binocdf(7,20,0.25))
fprintf("%.6f\n",1-binopdf(20,20,0.25)-binocdf(9,20,0.25))
fprintf("%.6f\n",(1 - binocdf(9,20,0.25)) / (1 - binocdf(2,20,0.25)));



