#pragma once
#include <iostream>
#include <cmath>

using namespace std;

class cNum {
protected: 
	double r, i;

public:
	cNum();
	cNum(double _r, double _i);
	cNum(const cNum &cn);

	cNum add(const cNum &cn);
	cNum sub(const cNum &cn);
	cNum mult(const cNum &cn);
	cNum div(const cNum &cn);
	cNum conj();
	cNum sqrt();

	double mag();
	double getR()const;
	double getI()const;
	void setR(double R);
	void setI(double I);
	void print();
	bool equals(const cNum &rhs);

	~cNum();//distructor 

};