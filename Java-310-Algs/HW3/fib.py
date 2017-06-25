def fib(N):
	if(N==1 or N==2):
		return 1
	else:
		val1= N-1
		val2= N-2
		return fib(val1)+fib(val2)
def recPow(x, y):
	if(x==0):
		return 0
	if(y==1):
		return x
	else:
		return x* recPow(x, y-1)
		
def recPow2(x,y):
	if(x==0):
		return 0
	if(y==1):
		return x
	if(y%2== 0):
		return recPow2(x, y/2)* recPow2(x,y/2)
	else:
		return x*recPow2(x, y/2)* recPow2(x,y/2)
		
def intmult(m,n):
	if(n==1):
		return m
	else:
		return m+ intmult(m,n-1)

def footlog(n):
	if(n==1):
		return 0
	else:
		return 1+footlog(n/2.0)
print(fib(5))
print(recPow(2,4))
print(recPow2(2,4))
print(intmult(5,3))
print(footlog(2))