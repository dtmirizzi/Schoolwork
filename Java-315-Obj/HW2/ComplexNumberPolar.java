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
public class ComplexNumberPolar extends ComplexNumber {

    public ComplexNumberPolar(){
	super(0,0);
    }

    public ComplexNumberPolar(double r, double i){
	super(r, i);
    }
    


    public ComplexNumberPolar(ComplexNumberPolar cn){
	super(cn.getR(), cn.getI());
    }


    public ComplexNumberPolar(ComplexNumber cn){
	super(cn.getR(),cn.getI());
    }

    public void finalize(){
	
    }
    public void setR(double r){
	super.setR(r);
    }

    public void setI(double i){
	super.setI(i);
    }

    public double getRadius(){
	return Math.sqrt(this.getR()*this.getR()+this.getI()*this.getI()); 
    }

    public double getTheta(){
	return Math.atan(this.getI()/this.getR());
    }

    public String toString(){
	return (this.getRadius()+"(cos("+this.getTheta()+") + isin("+this.getTheta()+")).");
    }
    
    public ComplexNumberPolar pow(int pwr){
	return new ComplexNumberPolar(radToR(Math.pow(this.getRadius(), pwr),pwr*this.getTheta()),thetaToI(Math.pow(this.getRadius(), pwr),pwr*this.getTheta()));
    }

    public ComplexNumberPolar mult(ComplexNumberPolar rhs){
	double rad1=this.getRadius();
	double rad2=rhs.getRadius();
	double theta1= this.getTheta();
	double theta2= rhs.getTheta();
	return new ComplexNumberPolar(radToR(rad1*rad2, theta1+theta2), thetaToI(rad1*rad2, theta1+theta2));
    }
    public ComplexNumberPolar div(ComplexNumberPolar rhs){
	double rad1=this.getRadius();
	double rad2=rhs.getRadius();
	double theta1= this.getTheta();
	double theta2= rhs.getTheta();
	return new ComplexNumberPolar(radToR(rad1/rad2, theta1-theta2), thetaToI(rad1/rad2, theta1-theta2));
    }
    boolean equals(ComplexNumberPolar rhs){
	return Math.abs(rhs.getRadius()-this.getRadius()) < .001&& Math.abs(rhs.getTheta()-this.getTheta())< .001;
    }
    private double radToR(double rad,double theta){
	return rad*Math.cos(theta);
    }
    private double thetaToI(double rad,double theta){
	return rad*Math.sin(theta);
    }
    
}
