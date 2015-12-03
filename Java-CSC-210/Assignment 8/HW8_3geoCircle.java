package HW;
//@author dtmirizzi

public class HW8_3geoCircle extends HW8_4Circle {

    private HW7_1MyPoint point;

    public HW8_3geoCircle(double _r, HW7_1MyPoint _point) {
        super(_r);
        
        this.point = _point;

    }
    public HW8_3geoCircle(){
        this(1,new HW7_1MyPoint(0,0));
    }

    public HW7_1MyPoint getPoint() {
        return point;
    }

}
