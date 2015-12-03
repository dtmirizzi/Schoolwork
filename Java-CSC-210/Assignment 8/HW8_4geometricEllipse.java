package HW;
//@author dtmirizzi

public class HW8_4geometricEllipse extends HW8_4Eclipse {
    private HW7_1MyPoint point;

    public HW8_4geometricEllipse(double Major, double Minor, HW7_1MyPoint _Point) {
        super(Major, Minor);
        this.point = _Point;
    }

    public HW8_4geometricEllipse() {
        this(1,1,new HW7_1MyPoint());
    }

    public HW7_1MyPoint getPoint() {
        return point;
    }

}
