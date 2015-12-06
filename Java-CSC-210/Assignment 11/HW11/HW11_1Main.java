package HW.HW11;
// @author dtmirizzi

public class HW11_1Main {

    public static void main(String[] args) {
        HW11_1MyArrayList l = new HW11_1MyArrayList();
        HW11_1MyArrayList r = new HW11_1MyArrayList();
        HW11_1MyArrayList k = new HW11_1MyArrayList();
        l.add(5);
        l.add(2);
        l.add(8);
        l.add(6);
        l.add(4);
        l.add(3);
        r.add(4);
        r.add(7);
        r.add(35);
        r.add(9);
        r.add(3);
        k.add(5);
        k.add(8);
        k.add(6);
        k.add(3);
        System.out.println(l.toString());
        l.delete(4);
        System.out.println(l.toString());
        l.delete(1);
        System.out.println(l.toString());
        System.out.println(l.contains(6));
        System.out.println(l.contains(20));
        System.out.println(l.equals(r));
        System.out.println(l.equals(k));

    }

}
