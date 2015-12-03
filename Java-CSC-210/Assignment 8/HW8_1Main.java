package HW;
// @author dtmirizzi

public class HW8_1Main {

     
    public static void main(String[] args) {
        HW7_1MyPoint aPoint= new HW7_1MyPoint();
        HW7_1MyPoint bPoint= new HW7_1MyPoint();

        HW8_1Rectangle a= new HW8_1Rectangle(5,3,aPoint);
        HW8_1Rectangle b= new HW8_1Rectangle(3,3,bPoint);
       
        System.out.println(a.getArea());
        System.out.println(b.getArea());
        System.out.println(a.getW());
        System.out.println(a.getCenter());
        System.out.println(b.getCenter());
        System.out.println(b.getW());
        System.out.println(a.getL());
        System.out.println(b.getL());

    }

}
