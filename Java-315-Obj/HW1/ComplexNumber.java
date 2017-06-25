/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW;

/**
 *
 * @author dtmirizzi
 */
public class ComplexNumber {

    private double r;
    private double i;

    public ComplexNumber() {
	this.r = 0;
	this.i = 0;
    }

    public ComplexNumber(double _r, double _i) {
	this.r = _r;
	this.i = _i;
    }

    public ComplexNumber(ComplexNumber rhs) {
	this.r = rhs.getR();
	this.r = rhs.getI();
    }

    public void finalize() throws Throwable {
	System.out.println("From Finalize Method");
        super.finalize();
    }

    public void setR(double r) {
	this.r = r;
    }

    public void setI(double i) {
	this.i = i;
    }

    public double getR() {
	return this.r;
    }

    public double getI() {
	return this.i;
    }

    public String toString() {
	String a= this.r+ "+"+this.i+"i";
	return a; 
    }

    public ComplexNumber add(ComplexNumber rhs) {
	return new ComplexNumber(this.r+rhs.getR(), this.i+rhs.getI());
    }

    public ComplexNumber sub(ComplexNumber rhs) {
	return new ComplexNumber(this.r-rhs.getR(), this.i-rhs.getI());
    }

    public ComplexNumber mult(ComplexNumber rhs) {
	return new ComplexNumber(this.r*rhs.getR()-this.i*rhs.getI(), 
		this.i*rhs.getI()+this.r*rhs.getR());
    }

    public ComplexNumber div(ComplexNumber rhs) {
	if(rhs.i==0&&rhs.r==0)return new ComplexNumber();
	return new ComplexNumber((this.r*rhs.getR()+this.i*rhs.getI())/((rhs.getR()*rhs.getI())*(rhs.getR()*rhs.getI())),
		this.i*rhs.getR()-this.r*rhs.getI()/((rhs.getR()*rhs.getI())*(rhs.getR()*rhs.getI())));
    }

    public double mag() {
	return Math.sqrt(this.r*this.r+ this.i* this.i);
    }

    public ComplexNumber conj() {
	return new ComplexNumber(this.r, -1* this.i);

    }

    public ComplexNumber sqrt() {
	if(this.i!=0){
	    double temp= (this.r*std::sqrt(this.r*this.r*this.i*this.i))/2;
	    double temp2= ((-1*this.r)*std::sqrt(this.r*this.r*this.i*this.i))/2;
	    return new ComplexNumber(temp, temp2);
	}
	else{
	    if(this.r>=0){
		return new ComplexNumber(std::sqrt(this.r), 0);
		
	    }else{
		return new ComplexNumber(0, std::sqrt(this.r*-1));
	    }
	}
	    
    }

    public boolean equals(ComplexNumber rhs) {
	if(this.r==rhs.getR()&&this.i==rhs.getI())
	    return true;
	else return false;
    }


}

