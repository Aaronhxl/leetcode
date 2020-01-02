package zju.cst.hl.interview;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Number_20 {
    public static void main(String[] args) {

        System.out.println(new Number_20().isValid("()[]{}"));

    }

    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length() ; i++) {
            String now = s.charAt(i) + "";
            if(stack.isEmpty()){
                stack.push(now);
                continue;
            }
            String peek = stack.peek();
            if(judge(peek,now)){
                stack.pop();
            }else {
                stack.push(now);
            }
        }
        if(stack.size() == 0){
            return true;
        }
        return false;
    }

    private boolean judge(String s1,String s2){
        if(s1.equals("(") && s2.equals(")")){
            return true;
        }
        if(s1.equals("[") && s2.equals("]")){
            return true;
        }
        if(s1.equals("{") && s2.equals("}")){
            return true;
        }
        return false;
    }

    /**
     * 栈的使用
     */
}
