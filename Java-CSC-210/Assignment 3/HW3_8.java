package HW;
// @author dtmirizzi

public class HW3_8 {

    public static void main(String[] args) {
        int n;
        double Pi4;
        for (n = 0, Pi4 = 0; n <= 10000; n++) {
            Pi4 = Pi4 + (Math.pow(-1.0, n) / ((2 * n) + 1));
        }
        System.out.println("i=10000, Pi=" + Pi4 * 4);
        for (n = 0, Pi4 = 0; n <= 20000; n++) {
            Pi4 = Pi4 + (Math.pow(-1.0, n) / ((2 * n) + 1));
        }
        System.out.println("i=20000, Pi=" + Pi4 * 4);
        for (n = 0, Pi4 = 0; n <= 100000; n++) {
            Pi4 = Pi4 + (Math.pow(-1.0, n) / ((2 * n) + 1));
        }
        System.out.println("i=100000, Pi=" + Pi4 * 4);

        //https://en.wikipedia.org/wiki/Leibniz_formula_for_%CF%80
    }

}
