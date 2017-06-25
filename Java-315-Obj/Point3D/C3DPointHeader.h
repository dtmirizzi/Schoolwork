#include <iostream>
#include "stdio.h"

using namespace std;

class C3DPoint {
protected: 
	double X, Y, Z;

public://--Public methods for header file
	C3DPoint();//constructor 
	C3DPoint(double x, double y,double z);
	C3DPoint add(C3DPoint p);
	C3DPoint sub(C3DPoint p);
	double dot(C3DPoint p);
	C3DPoint cross(C3DPoint p);
	double getX();
	double getY();
	double getZ();
	void setX(double x);
	void setY(double y);
	void setZ(double z);
	void print();
	~C3DPoint();//distructor 

};