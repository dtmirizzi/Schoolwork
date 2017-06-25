#include "cNumP.h"


cNumP::cNumP() : cNum(){

}
cNumP::cNumP(double r, double i) : cNum(r, i){

}
cNumP::cNumP(const cNumP &cn) : cNum(cn.getR(), cn.getI()){

}
cNumP::cNumP(const cNum &cn) : cNum(cn){

}

void cNumP::setR(double r){
	cNum::setR(r*std::cos(getTheta()));
}
void cNumP::setI(double i){
	cNum::setI(getRadius()*std::cos(i));
}
double cNumP::getRadius()const{
	return std::sqrt(cNum::getR()*cNum::getR()+cNum::getI()*cNum::getI());
}
double cNumP::getTheta()const{
	return std::atan(cNum::getI()/cNum::getR());
}
void cNumP::print(){
	cout<< getRadius()<< " (cos("<< getTheta()<<") + isin("<< getTheta()<<"))"<<endl;
}
cNumP cNumP::mult(const cNumP &rhs){
	double rad1=getRadius();
	double rad2=rhs.getRadius();
	double theta1= getTheta();
	double theta2= rhs.getTheta();
	return cNumP(radToR(rad1*rad2, theta1+theta2), thetaToI(rad1*rad2, theta1+theta2));
}
cNumP cNumP::div(const cNumP &rhs){
	double rad1=getRadius();
	double rad2=rhs.getRadius();
	double theta1=getTheta();
	double theta2= rhs.getTheta();
	return cNumP(radToR(rad1/rad2, theta1-theta2), thetaToI(rad1/rad2, theta1-theta2));
}
cNumP cNumP::pow(double pwr){
	return cNumP(radToR(std::pow(getRadius(), pwr),pwr*getTheta()),thetaToI(std::pow(getRadius(), pwr),pwr*getTheta()));
}
bool cNumP::equals(const cNumP &rhs){
	return std::fabs(rhs.getRadius()-getRadius()) < .001&& std::fabs(rhs.getTheta()-getTheta())< .001;
}
cNumP::~cNumP(){

}
double cNumP::radToR(double rad,double theta){
	return rad*std::cos(theta);
}
double cNumP::thetaToI(double rad,double theta){
	return rad*std::sin(theta);
}