#include "CComplexNumbers.h"
#include "cNumP.h"

int main (int argc ,char **argv){
	cNumP a= cNumP(2,2);
	cNumP b= cNumP();
	b.setR(1);
	b.setI(2);
	b.print();
	cNumP c= cNumP(a);
	a.mult(b).print();
	a.div(b).print();
	a.pow(2).print();
}