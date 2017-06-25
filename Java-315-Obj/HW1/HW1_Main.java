/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HW;

/**
 * @author dtmirizzi
 */
public class HW1_Main {

    
    public static void main(String[] args) throws Throwable {
        ComplexNumber a= new ComplexNumber(3,4); 
	ComplexNumber c= new ComplexNumber(1,4); 
	ComplexNumber b= new ComplexNumber(2,2); 
	ComplexNumber d= new ComplexNumber(); 
	ComplexNumber e= new ComplexNumber(a);
	d.finalize();
	System.out.println(a.toString());
	a.setI(2);
	a.setR(5);
	System.out.println(a.getR());
	System.out.println(a.getI());
	System.out.println(a.add(e).toString());
	System.out.println(a.div(b).toString());
	System.out.println(a.sub(e).toString());
	System.out.println(a.mult(e).toString());
	System.out.println(a.mag());
	System.out.println(a.conj().toString());
	System.out.println(a.sqrt().toString());
	System.out.println(c.equals(e));
	System.out.println(b.equals(b));
	
    }

}
