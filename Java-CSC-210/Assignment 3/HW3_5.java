package HW;
// @author dtmirizzi
import java.util.Scanner;

public class HW3_5 {

     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Principal:");
        double p = sc.nextInt();
        System.out.println("Investment Term:");
        int n = sc.nextInt();
        System.out.println("Rate of Return:");
        double r = sc.nextInt();
        int i;
        double total=p;
        for(i=1;i<=n;i++){
            System.out.println("year:"+i+" value q1:"+total);
            total=(p)*Math.pow(Math.E, (i*(r/100.0)));
            System.out.println("year:"+i+" value q4:"+total);
            System.out.println("");
        }

    }

}
