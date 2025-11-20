A = [1 0 -2, 2 1 3, -2 3 0]
A = [1 0 -2; 2 1 3; -2 3 0]
A - 2
B = [ 2 1 1; 1 0 1; 1 -1 0]
C = A - B
D = A * B
E = A .* B
A + transpose(A)
C + transpose(C)
E + transpose(E)
x = A(1,:)*B(:,2)
y = A(:,2)*B(3,:)
y = A(:,2)*B(3,:)
y = B(3,:)*A(:,2)
edit tiberia.m
tiberia(1, 3)
tiberia(1,3)
tiberia(1,3)
tiberia(7,10)
tiberia(15,25)
help plot
y = @(x)x.^2
x = linspace(0, 2)
x = linspace(0, 2, 10)
y(x)
A = [1 0 -2, 2 1 3, -2 3 0]
A = [1 0 -2, 2 1 3, -2 3 0]
A = [1 0 -2; 2 1 3; -2 3 0]
y(x)
A = [1 0 -2, 2 1 3, -2 3 0]
A = [1 0 -2; 2 1 3; -2 3 0]
tiberia(1, 3)
tiberia(10, 7)
clc
y = @(x) x.^2
x = linspace(0, 2, 5)
x = linspace(0, 2, 5)
plot(x, y)
y2 = @(x) x.^(1/2)
y3 = @(x) x
y(x)
x = linspace(0,2,5)
a = x.^2
b = x.^(1/2)
c = x
plot(x, a, b, c, '.')
x = linspace(0,2,100)
plot(x, a, b, c, '.')
a = x.^2
b = x.^(1/2)
c = x
plot(x, a, b, c, '.')
clc
lambda = 1/2
lambda = 1/2;
f = @(x) lambda*exp(-lambda*x)
y1=f(x);
plot(x, y1, 'r')
lambda = 3
f = @(x) lambda*exp(-lambda*x)
y2=f(x);
plot(x, y2, 'b')
lambda = 7
f = @(x) lambda*exp(-lambda*x)
y3=f(x);
plot(x, y3, 'p')
plot(x, y3, 'k')
plot(x, y3, 'k');hold on;
plot(x, y3, 'k');hold on;
plot(x, y2, 'b');hold on;plot(x, y3, 'k');hold on;
plot(x, y2, 'b');hold on;plot(x, y3, 'k');hold on;
plot(x, y2, 'b');hold on;plot(x, y3, 'k');hold on;plot(x,y1, 'r');
