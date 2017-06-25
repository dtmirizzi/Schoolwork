#include "C3DPointHeader.h"

int main (int argc ,char **argv){

	C3DPoint p1(1,2,3);
	C3DPoint p2(1,2,3);
	C3DPoint p3=p1.add(p2);
	C3DPoint p4=p1.sub(p2);
	printf("%f\n", p1.getX());
	
}