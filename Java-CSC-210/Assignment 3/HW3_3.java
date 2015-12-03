package HW;
// @author dtmirizzi

import java.util.Scanner;

public class HW3_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input an int to sum to:");
        int n = sc.nextInt();
        int i, sum = 0;
        for (i = 0; i <= n; i++) {
            if (i % 2 != 0){
                sum=sum+i;
            }
        }
        System.out.println(sum);
    }

}
