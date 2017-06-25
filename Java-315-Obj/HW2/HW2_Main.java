/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HW;

/**
 * @author dtmirizzi
 */
public class HW2_Main {

    
    public static void main(String[] args) {
        ComplexNumberPolar a= new ComplexNumberPolar(3,4); 
	ComplexNumberPolar c= new ComplexNumberPolar(1,4); 
	ComplexNumberPolar b= new ComplexNumberPolar(2,2); 
	ComplexNumberPolar d= new ComplexNumberPolar(); 
	ComplexNumberPolar e= new ComplexNumberPolar(a);
	d.finalize();
	System.out.println(a.getRadius());
	System.out.println(a.getTheta());
	System.out.println(a.div(e));
	System.out.println(a.equals(e));
	System.out.println(a.pow(2));
	System.out.println(a.mult(e));
	a.setI(1);
	a.setR(5);
	a.toString();
    }

}
