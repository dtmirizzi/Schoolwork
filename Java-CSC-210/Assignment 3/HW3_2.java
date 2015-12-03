package HW;
// @author dtmirizzi

public class HW3_2 {

    public static void main(String[] args) {
        int sum = 0;
        int i;
        for (i = 0; i <= 50; i++) {
            if(i % 2 != 0){
            sum = sum + i;
            }
        }
        System.out.println(sum);

    }

}
