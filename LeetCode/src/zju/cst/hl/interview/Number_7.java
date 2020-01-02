package zju.cst.hl.interview;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class Number_7 {

    public static void main(String[] args) {
        reverse(1534236469);
    }

    public static int reverse(int x) {
        int flag = 1;
        if(x<0){
            flag = -1;
        }
        Integer value = Math.abs(x);
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        StringBuilder reverse = sb.reverse();
        Integer reverseValue = 0;
        try {
            reverseValue = Integer.valueOf(reverse.toString());
        }catch (Exception e){
            return 0;
        }
        int result = reverseValue*flag;
        return result;
    }
}
