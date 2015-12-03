package HW;
// @author dtmirizzi

import java.util.Scanner;

public class HW3_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double Max = java.lang.Double.MIN_VALUE, Min = java.lang.Double.MAX_VALUE;
        System.out.println("input a double, 0.0 to terminate:");
        double input = sc.nextDouble();
        if(java.lang.Math.abs(input)<0.001){
            System.out.println("No input terminating");
            
        }
        while (java.lang.Math.abs(input)>0.001) {
            if(input>Max){
                Max=input;
            }
            if(input<Min){
                Min=input;
            }
            System.out.println("input a double, 0.0 to terminate:");
            input = sc.nextDouble();
        }
        System.out.println("Max: "+Max);
        System.out.println("Min: "+Min);
     
    }

}
