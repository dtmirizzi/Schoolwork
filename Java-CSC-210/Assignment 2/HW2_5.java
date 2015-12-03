package HW;
// @author dtmirizzi

public class HW2_5 {

    public static void main(String[] args) {
        int input = 9;
        switch (input % 5) {
            case 0:
                System.out.println(input + " " + "Is Divisible By 5");
                break;
            default:
                System.out.println(input + " " + "Isn't Divisible By 5");
        }

    }

}
