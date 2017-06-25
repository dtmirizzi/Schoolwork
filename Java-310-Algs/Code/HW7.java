/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc.pkg310.alg;

/**
 *
 * @author dtmirizzi
 */
public class HW7 {
    public static int mults;
    public static int adds;
    	public static void main(String[] args) {
		//int[] a= {0,4,0,8,6,9,2,3};
		int[] a= {3,2,9,6,8,0,4,1};
		int[] b1={5,0,0,0,1};
		int[] b2={8,0,4,1};
		int[] b3={-37,2,-11,1};
		System.out.println(standard(a,2));
		System.out.println(mults +""+adds);
		mults=0;
		adds=0;
		System.out.println(Horner(a,2));
		System.out.println(mults +""+adds);
		mults=0;
		adds=0;
		System.out.println(Horner(b1,2)*Horner(b2,2)+Horner(b3,2));
		System.out.println(mults +""+adds);
		mults=0;
		adds=0;

	}
	
	public static int standard(int[] a, int x){
		int result =a[0]+a[1]*x;
		int POW =x;
		for(int i =2; i<a.length; i++){
			POW*= x;
			result+= (a[i]*POW);
			mults++;
			adds++;
		}
		
		return result;
	}
	
	public static int Horner(int[] a, int x){
		int result= a[a.length-1];
		for(int i= a.length-2; i>=0;i--){
			result*= x;
			result+=a[i];
			mults++;
			adds++;
		}
		return result;
	}
	

}
