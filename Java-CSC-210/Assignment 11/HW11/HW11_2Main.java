package HW.HW11;
// @author dtmirizzi

public class HW11_2Main {

    public static void main(String[] args) {
        HW11_2MyLinkedList l = new HW11_2MyLinkedList();
        HW11_2MyLinkedList h = new HW11_2MyLinkedList();
        h.add("DT is pretty cool");
        h.add("... Not");
        l.add(34);
        l.add(5);
        l.add(7);
        l.add(9);
        l.add(32);
        h.delete(1);
        System.out.println(l.toString());
        l.delete(2);
        System.out.println(l.toString());
        System.out.println(l.contains(32));
        System.out.println(l.contains(16));
        System.out.println(l.equals(l));
        System.out.println(h.toString());
        System.out.println(l.equals(h));
    }

}
