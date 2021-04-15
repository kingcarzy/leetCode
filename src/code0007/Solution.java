package code0007;

public class Solution {
    public static void main(String[] args) {
        int x = -123;
        // 2147483648
        //int x = 1534236469;
        int reverse = reverse(x);
        System.out.println(reverse);

    }
    public static int reverse(int x) {
        int flag = 0; // 判断正负
        int result = 0;

        if ( x >= 0){
            flag = 1;
        }else {
            x = x * -1;
        }
        int key = 10;
        while (x > 0){
            try {
                result = Math.multiplyExact(result, 10);
            } catch (Exception e) {
                return 0;
                //e.printStackTrace();
            }
            int value = x % 10;
            x = (x - value) / 10;
            result = result + value;
        }
        if (flag == 0){
            result = result * -1;
        }
        return result;
    }

}
