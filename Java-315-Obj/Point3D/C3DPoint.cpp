#include "C3DPointHeader.h"

C3DPoint::C3DPoint(){
	this->X=0;
	this->Y=0;
	this->Z=0;
}
C3DPoint::C3DPoint(double x, double y,double z){
	this->X=x;
	this->Y=y;
	this->Z=y;
}
C3DPoint C3DPoint::add(C3DPoint p){
	return(C3DPoint(this->X+p.X, this->Y+p.Y, this->Z+p.Z));
}
C3DPoint C3DPoint::sub(C3DPoint p){
	return(C3DPoint(this->X-p.X, this->Y-p.Y, this->Z-p.Z));
}
double C3DPoint::dot(C3DPoint p){
	return(this->X+p.X+this->Y+p.Y+this->Z+p.Z);
}
C3DPoint C3DPoint::cross(C3DPoint p){
	double FinX, FinY, FinZ;
	FinX= (Y*p.Z)- (Z-p.Y);
	FinY= (Z*p.X)- (X-p.Z);
	FinZ= (X*p.Y)- (Y-p.X);
	return(C3DPoint(FinX,FinY ,FinZ));
}
double C3DPoint::getX(){
	return(this->X);
}
double C3DPoint::getY(){
	return(this->Y);
}
double C3DPoint::getZ(){
	return(this->Z);
}
void C3DPoint::setX(double x){
	this->X=x;
}
void C3DPoint::setY(double y){
	this->Y=y;
}
void C3DPoint::setZ(double z){
	this->Z=z;
}
void C3DPoint::print(){
	printf("%f, %f, %f\n", this->X, this->Y,this->Z);
}
C3DPoint::~C3DPoint(){
	
}
