package HW;
// @author dtmirizzi

public class HW4_1 {

    public static double distance(double x1, double y1, double x2, double y2) {
        double hyp;
        double det = ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));
        hyp = Math.sqrt(det);
        return hyp;
    }

    public static void main(String[] args) {
        double x = distance(5.0, 5.0, 10.0, 10.5);
        System.out.println(x);

    }
}
