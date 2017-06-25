import matplotlib.pyplot as plt
from matplotlib.lines import Line2D
import math

File = open('Points', 'w')

def f(x):
	return math.pow(2,x)
def logN(x):
	return math.log10(x)
def nsqrd(x):
	return x*x


x= [0]
y= [0]
for i in range(1,7):
	y.append(f(i))
	x.append(i)
for item in y:
  File.write("%s\n" % item)
File.write("-----------\n")
plt.plot(x,y)


x= [0]
y= [0]

for i in range(1,7):
	y.append(i*2)
	x.append(i)
for item in y:
  File.write("%s\n" % item)
File.write("-----------\n")
plt.plot(x,y)

x= [0]
y= [0]

for i in range(1,7):
	y.append(logN(i))
	x.append(i)
for item in y:
  File.write("%s\n" % item)
File.write("-----------\n")
plt.plot(x,y)

x= [0]
y= [0]

for i in range(1,7):
	y.append(nsqrd(i))
	x.append(i)
for item in y:
  File.write("%s\n" % item)
File.write("-----------\n")
plt.plot(x,y)

x= [0]
y= [0]

for i in range(1,7):
	y.append(math.factorial(i))
	x.append(i)
for item in y:
  File.write("%s\n" % item)
File.write("-----------\n")
plt.plot(x,y)

x= [0]
y= [0]

for i in range(1,7):
	y.append(logN(i)*logN(i))
	x.append(i)
for item in y:
  File.write("%s\n" % item)
File.write("-----------\n")
plt.plot(x,y)

x= [0]
y= [0]

for i in range(2,7):
	y.append(math.log10(logN(i)))
	x.append(i)
for item in y:
  File.write("%s\n" % item)
File.write("-----------\n")
plt.plot(x,y)

x= [0]
y= [0]

for i in range(1,7):
	y.append(i*i*i)
	x.append(i)
for item in y:
  File.write("%s\n" % item)
File.write("-----------\n")
plt.plot(x,y)

x= [0]
y= [0]

for i in range(1,7):
	y.append(math.sqrt(i))
	x.append(i)
for item in y:
  File.write("%s\n" % item)
File.write("-----------\n")
plt.plot(x,y)

x= [0]
y= [0]

for i in range(1,7):
	y.append(i)
	x.append(i)
for item in y:
  File.write("%s\n" % item)
File.write("-----------\n")
plt.plot(x,y)

x= [0]
y= [0]

for i in range(1,7):
	y.append(i*i*i+logN(i))
	x.append(i)
for item in y:
  File.write("%s\n" % item)
File.write("-----------\n")
plt.plot(x,y)

x= [0]
y= [0]

for i in range(1,7):
	y.append(i-i*i+5*i*i*i)
	x.append(i)
for item in y:
  File.write("%s\n" % item)
File.write("-----------\n")
plt.plot(x,y)

x= [0]
y= [0]

for i in range(1,7):
	y.append(6)
	x.append(i)
for item in y:
  File.write("%s\n" % item)
File.write("-----------\n")
plt.plot(x,y)

x= [0]
y= [0]

for i in range(1,7):
	y.append(math.pow(2,i-1))
	x.append(i)
for item in y:
  File.write("%s\n" % item)
File.write("-----------\n")
plt.plot(x,y)

x= [0]
y= [0]

for i in range(1,7):
	y.append(i*logN(i))
	x.append(i)
for item in y:
  File.write("%s\n" % item)
File.write("-----------\n")
plt.plot(x,y)

x= [0]
y= [0]

for i in range(1,7):
	y.append(math.pow(3/2,i))
	x.append(i)
for item in y:
  File.write("%s\n" % item)
File.write("-----------\n")
plt.plot(x,y)

plt.legend(['data', 'linear', 'cubic'], loc='best')
plt.show()

plt.show();