package HW;
// @author dtmirizzi

public class HW3_7 {

    public static void main(String[] args) {
        int n, sum = 0,prevN=0;
        for (n = 0; sum <= 1200; ++n) {
            sum = n * n;
            if (sum >= 1200) {
                System.out.println("over estimate: smallest positive int,n,such that n^2>1200:" + n);
                System.out.println("under estimate: smallest positive int,n,such that n^2>1200:" + prevN);
                System.out.println("actual for comparison: smallest positive Real number,n,such that n^2>1200:" +Math.sqrt(1200.0));
            }
            prevN=n;
        }

    }

}
