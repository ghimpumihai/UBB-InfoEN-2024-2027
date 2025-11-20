N = 1e6;
U = rand(N,1);
V = rand(N,1);

inside = (U.^2 + V.^2) <= 1;
pi_est = 4 * mean(inside)
