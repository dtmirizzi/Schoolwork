package HW;
// @author dtmirizzi

public class HW4_5 {
    public static int lowestFac(int n){
        int M,i,sum;
        for(i=0,sum=0,M=0;sum<n;++i){
            sum=sum+i;
            M=i;
        }
        return M;
    }

    public static void main(String[] args) {
        System.out.println(lowestFac(100));

    }

}
