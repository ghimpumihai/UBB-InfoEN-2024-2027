pkg load statistics
mu = 198;
sigma = 8.8;


p_a_analytical = 1 - normcdf(210, mu, sigma)
p_b_analytical = 0
p_c_analytical = 1 - normcdf(210, mu, sigma)
p_d_analytical = normcdf(220, mu, sigma) - normcdf(190, mu, sigma)
q20_analytical = norminv(0.20, mu, sigma)
q85_analytical = norminv(0.85, mu, sigma)



N = 1e6;
U = rand(N/2,1);
V = rand(N/2,1);
R = sqrt(-2*log(U));
Z1 = R .* cos(2*pi*V);
Z2 = R .* sin(2*pi*V);
Z = [Z1; Z2];

samples = mu + sigma * Z;

p_a_sim = mean(samples > 210)
p_b_sim = mean(samples ==210)
p_c_sim = mean(samples >= 210)
p_d_sim = mean(samples >= 190 & samples <= 220)
q20_sim = quantile(samples, 0.20)
q85_sim = quantile(samples, 0.85)
