N = 1e6;
N_area = 0;
for i = 1:N
    X = unifrnd(0,1);
    Y = unifrnd(0,1);
    if Y <= sin(nthroot(X,3))
        N_area = N_area + 1;
    end
end
approx_area = N_area / N

