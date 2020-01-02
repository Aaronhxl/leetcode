package zju.cst.hl.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Number_17 {
    public static void main(String[] args) {

        List<String> list = new Number_17().letterCombinations("");
        for (String s : list) {
            System.out.println(s);
        }

    }

    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return result;
        }

        Map<String,String> map = new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        function("",digits,digits.length(),map);
        return result;
    }

    public void function(String target,String source,int length,Map<String,String> map){

        if(target.length() == length){
            result.add(target);
        }

        if(source != null && source.length() > 0){
            String firstDigit = source.substring(0, 1);
            String nextSource = null;
            if(source.length()>1){
                nextSource = source.substring(1);
            }
            String letterList = map.get(firstDigit);
            for (int i = 0; i < letterList.length() ; i++) {
                function(target+letterList.charAt(i),nextSource,length,map);
            }
        }
    }


    /**
     * 分析：
     *      1.映射关系已经有了
     *      2.组合排列
     *      3.结果为它能表示的字母组合
     *      4.可以递归或者动态规划
     *          问题的规模呈现 f(n) = f(n-1) + n的形式
     *
     *          函数入口：
     */
}
