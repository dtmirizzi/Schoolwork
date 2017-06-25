#pragma once
#include "CComplexNumbers.h"

class cNumP : public cNum{
	public:
	cNumP();
	cNumP(double r, double i);
	cNumP(const cNumP &cn);
	cNumP(const cNum &cn);
	virtual ~cNumP();
	void setR(double r);
	void setI(double i);
	double getRadius()const;
	double getTheta()const;
	void print();
	cNumP mult(const cNumP &rhs);
	cNumP div(const cNumP &rhs);
	cNumP pow(double pwr);
	bool equals(const cNumP &rhs);
protected:
	double radToR(double rad,double theta);
	double thetaToI(double rad,double theta);
};