#include "CComplexNumbers.h"

int main (int argc ,char **argv){
	cNum a= cNum(2,2);
	cNum b= cNum();
	b.setR(1);
	b.setI(2);
	b.print();
	cNum c= cNum(a);
	printf("gitters %f %f\n", b.getR(), b.getI());
	a.add(b).print();
	a.sub(b).print();
	a.mult(b).print();
	a.div(b).print();
	a.conj().print();
	a.sqrtk().print();
	printf("mag: %f\n", a.mag());
	printf(a.mag() ? "true\n" : "false\n");
	
}