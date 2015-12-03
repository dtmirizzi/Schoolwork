package HW;
//@author dtmirizzi

public class HW8_1Rectangle {

    private double x, y, w, l;
    private HW7_1MyPoint point;

    public HW8_1Rectangle(double _l, double _w, HW7_1MyPoint _point) {
        this.point= _point;
        this.w = _w;
        this.l = _l;

    }
    public HW7_1MyPoint getCenter(){
        return point;
    }

    public double getW() {
        return w;
    }

    public double getL() {
        return l;
    }

    public double getArea() {
        return this.l * this.w;
    }

}
