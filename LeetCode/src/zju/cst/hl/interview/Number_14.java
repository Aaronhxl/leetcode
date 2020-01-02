package zju.cst.hl.interview;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class Number_14 {

    public static void main(String[] args) {

        String[] strs = {"a"};
        System.out.println(longestCommonPrefix(strs));

    }


    public static String longestCommonPrefix(String[] strs) {
        String answer = "";
        if(strs == null || strs.length == 0) {
            return null;
        }
        int index = 0;
        int maxLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length ; i++) {
            if(strs[i].length() < maxLength){
                maxLength = strs[i].length();
            }
        }
        while (true && maxLength > 0){
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length ; i++) {
                if(c != strs[i].charAt(index)){
                    return answer;
                }
            }
            answer += c;
            if(++index >= maxLength) break;
        }
        return answer;
    }

    /**
     * 很简单了，直接用计数器就ok，保证每次的移动 时间复杂度应该是线性的 string底层是数组实现
     */
}
