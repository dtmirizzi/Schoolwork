package HW;
// @author dtmirizzi

public class HW4_2 {

    public static double distance(double x1, double y1, double x2, double y2) {
        double hyp;
        double det = ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));
        hyp = Math.sqrt(det);
        return hyp;
    }
    
    public static double recArea(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double area;
        area= (distance(x1,y1,x2,y2)*distance(x2,y2,x3,y3));
        return area;
    }
     
    public static void main(String[] args) {
        System.out.println(recArea(0,0,4,0,4,5,0,5));

    }

}
