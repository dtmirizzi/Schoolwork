package HW;
// @author dtmirizzi

public class HW4_3 {

     public static double volCyl(double r, double h){
         double vol;
         vol= (Math.PI*r*r*h);
         return vol;
     }
    public static void main(String[] args) {
        System.out.println(volCyl(5,10));

    }

}
