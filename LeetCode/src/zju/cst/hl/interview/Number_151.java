package zju.cst.hl.interview;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class Number_151 {
    public static void main(String[] args) {
        System.out.println(new Number_151().reverseWords("  hello world!  "));

    }

    public String reverseWords(String s) {

        String result = "";
        if(s == null || s.length() == 0){
            return result;
        }
        String temp = s.trim();
        StringBuilder resultTemp = new StringBuilder();
        while (true){
            int index = temp.lastIndexOf(" ");
            if(index > 0){
                resultTemp.append(temp.substring(index+1));
                temp = temp.substring(0,index).trim();
            }else {
                resultTemp.append(temp);
                break;
            }
            resultTemp.append(" ");
        }
        result = resultTemp.toString().trim();
        return result;
    }


}
