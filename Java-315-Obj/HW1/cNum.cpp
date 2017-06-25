#include "CComplexNumbers.h"

cNum::cNum(){
	this->r=0;
	this->i=0;
}
cNum::cNum(double _r, double _i){
	this->r=_r;
	this->i=_i;
}
cNum::cNum(const cNum& cn){
	this->r =cn.getR();
	this->i =cn.getI();
}
cNum cNum::add(const cNum& cn){
	double a= this->r;
	double b= this->i;
	double c= cn.getR();
	double d= cn.getI();
	return cNum(a+c, b+d);
}
cNum cNum::sub(const cNum& cn){
	double a= this->r;
	double b= this->i;
	double c= cn.getR();
	double d= cn.getI();
	return cNum(a-c, b-d);
}
cNum cNum::mult(const cNum& cn){
	double a= this->r;
	double b= this->i;
	double c= cn.getR();
	double d= cn.getI();
	double x= a*c-b*d;
	double y= a*d+b*c;
	return cNum(x,y);
}
cNum cNum::div(const cNum& cn){
	double a= this->r;
	double b= this->i;
	double c= cn.getR();
	double d= cn.getI();
	return cNum((a*c + b*d)/(c*c+d*d) , (b*c - a*d)/(c*c+d*d));
}
cNum cNum::conj(){
	return cNum(this->r, this->i*-1);
}
cNum cNum::sqrt(){
	if(rhs->this->i==0&&this->r==0)return new cNum();
	double a= this->r;
	double b= this->i;
	return cNum(std::sqrt((a+std::sqrt(a*a+b*b))/2) , std::sqrt((-1*a+std::sqrt(a*a+b*b))/2));
}
bool cNum::equals(const cNum& cn){
	return (this->r==cn.getR()&&this->i==cn.getI());
}
double cNum::getR()const{
	return(this->r);
}
double cNum::mag(){
	return std::sqrt(this->r*this->r+this->i*this->i);
}
double cNum::getI()const{
	return(this->i);
}
void cNum::setR(double R){
	this->r=R;
}
void cNum::setI(double I){
	this->i=I;
}
void cNum::print(){
	printf("%f+%fi\n", this->r, this->i);
}
cNum::~cNum(){
	
}
