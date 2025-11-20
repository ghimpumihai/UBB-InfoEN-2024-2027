
mean_time = 12;
lambda = 1 / mean_time;


p2a_analytical = 1 - expcdf(30, mean_time)
p2b_analytical = gamcdf(60, 3, mean_time)


N = 1e6;

U = rand(N,1);
X = -log(U) / lambda;
p2a_sim = mean(X > 30)

U3 = rand(N,3);
Y3 = -log(U3) / lambda;
S3 = sum(Y3,2);
p2b_sim = mean(S3 < 60)


