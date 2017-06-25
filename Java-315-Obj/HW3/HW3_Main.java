/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HW;

/**
 * @author dtmirizzi
 */
public class HW3_Main {

    
    public static void main(String[] args) {
		Vector v0 = new Vector(1.0, 2.0, 3.0);
		Vector v1 = new Vector(4.0, 5.0, 6.0);
		VectorInterface vresult;
		vresult = v0.Add(v1);
		System.out.println(vresult);
		vresult = v0.Subtract(v1);
		System.out.println(vresult);
		System.out.println(v0.Multiply(2.0));
		System.out.println(v0.Dot(v1));
		System.out.println(v0.Cross(v1));
		System.out.println(v0.Norm());
		System.out.println(v0.Unit());
		v0 = new Vector(2, -3, 4);
		v1 = new Vector(5, 2, 1);
		System.out.println(v0.AngleBetween(v1) * 180.0 / Math.PI);
		System.out.println(v0.DirectionAngle(VectorInterface.XCOMPONENT));
		System.out.println(v0.DirectionAngle(VectorInterface.YCOMPONENT));
		System.out.println(v0.DirectionAngle(VectorInterface.ZCOMPONENT));
		System.out.println("parallel " + v0.Parallel(v0));
		System.out.println("parallel " + v0.Parallel(v1));
		v0 = new Vector(1, 0, 0);
		v1 = new Vector(-1, 0, 0);
		System.out.println("anti-parallel " + v0.AntiParallel(v1));
		System.out.println("anti-parallel " + v0.AntiParallel(v0));
		Vector vunit = (Vector)v0.Unit();
		System.out.println(vunit.Norm());
		System.out.println("equals " + v0.equals(v0));
		System.out.println("equals " + v0.equals(v1));
		v0 = new Vector(2, -3, 4);
		v1 = new Vector(5, 2, 1);
		System.out.println(v0.Projection(v1));

	}


}
