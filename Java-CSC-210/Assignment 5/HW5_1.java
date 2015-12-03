package HW;
// @author dtmirizzi

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HW5_1 {

    public static double sum(double[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        return sum;
    }

    public static double[] fill(int n, double v) {
        double[] a = new double[n];
        int i;
        for (i = 0; i < a.length; ++i) {
            a[i] = v;
        }
        return a;
    }

    public static double[] random(int n) {
        Random randomGenerator = new Random();
        double[] a = new double[n];
        int i;
        for (i = 0; i < a.length; ++i) {
            a[i] = randomGenerator.nextDouble();

        }
        return a;
    }

    public static double min(double[] a) {
        double Max = java.lang.Double.MIN_VALUE, Min = java.lang.Double.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
//            if(a[i]>Max){
//                Max=a[i];
//            }
            if (a[i] < Min) {
                Min = a[i];
            }

        }
        return Min;
    }

    public static double max(double[] a) {
        double Max = java.lang.Double.MIN_VALUE, Min = java.lang.Double.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > Max) {
                Max = a[i];
            }
//            if(a[i]<Min){
//                Min=a[i];
//            }

        }
        return Max;
    }

    public static double average(double[] a) {
        double avg = 0;
        for (int i = 0; i < a.length; i++) {
            avg = avg + a[i];
        }
        return avg / a.length;
    }

    public static double variance(double[] a) {
        double var = 0;
        double xBar = average(a);
        for (int i = 0; i < a.length; i++) {
            var = var + ((a[i] - xBar) * (a[i] - xBar));
        }
        return var / a.length;
    }

    public static double stdDev(double[] a) {
        return Math.sqrt(variance(a));
    }

    public static double[] read(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input array size:");
        int input = sc.nextInt();
        double[] a= new double[input];
        for(int i=0;i<input;i++){
            System.out.println("Input value:");
            a[i]= sc.nextDouble();
        }
        return a;
    }
    
    public static void print(double[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        double[] a = {2, 4, 12, 6, 8, 9};
        System.out.println(sum(a));
        System.out.println(Arrays.toString(fill(5,2.0)));
        System.out.println(Arrays.toString(random(5)));
        System.out.println(min(a));
        System.out.println(max(a));
        System.out.println(average(a));
        System.out.println(variance(a));
        System.out.println(stdDev(a));
        double[] x=read();
        System.out.println(Arrays.toString(x));
        print(a);

    }

}
