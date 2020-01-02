package zju.cst.hl.recursion;

import java.math.BigInteger;
import java.util.*;

/**
 * https://leetcode-cn.com/problems/number-of-atoms/
 */
public class Number_726 {

    public static void main(String[] args) {
        String s = new Number_726().countOfAtoms("Mg(OH)2");
        System.out.println(s);

    }


    public String countOfAtoms(String formula) {
        if(formula == null) return null;
        function(formula,1);
        StringBuilder sb = new StringBuilder();
        for (String s : temp.keySet()) {
            sb.append(s);
            Integer num = temp.get(s);
            if(num != 1){
                sb.append(num);
            }
        }
        return sb.toString();
    }

    private static Map<String,Integer> temp = new TreeMap<>();

    public void function(String formula , int value){

        int length = formula.length();
        int start = 0;
        for (int i = start; i < length ;) {
            if(Character.isUpperCase(formula.charAt(i)) && (i+1 < length)&& Character.isDigit(formula.charAt(i+1))){
                char c = formula.charAt(i);
                String key = c + "";
                String data = "";
                for (int j = i+1; j < length; j++) {
                    if(Character.isDigit(formula.charAt(j))){
                        data += formula.charAt(j);
                        continue;
                    }
                    break;
                }
                Integer num = Integer.valueOf(data);
                if(temp.containsKey(key)){
                    Integer originNum = temp.get(key);
                    temp.put(key,originNum + num*value);
                }else {
                    temp.put(key,num*value);
                }
                i+=(1+data.length());
            }
            else if((Character.isUpperCase(formula.charAt(i)) && (i + 1 < length) && (Character.isUpperCase(formula.charAt(i+1)) || (formula.charAt(i+1) == '(')))
                    || (Character.isUpperCase(formula.charAt(i)) && (i + 1 >= length))){
                char c = formula.charAt(i);
                String key = c + "";
                if(temp.containsKey(key)){
                    Integer originNum = temp.get(key);
                    temp.put(key,originNum + value);
                }else {
                    temp.put(key,value);
                }
                i+=1;
            }else if(Character.isUpperCase(formula.charAt(i)) && (i+1<length) && Character.isLowerCase(formula.charAt(i+1))){
                String key = formula.charAt(i)+"";
                for (int j = i+1; j < length ; j++) {
                    if(Character.isLowerCase(formula.charAt(j))){
                        key += formula.charAt(j);
                        continue;
                    }
                    break;
                }
                if(key.length()+i < length && Character.isDigit(formula.charAt(i+key.length()))){
                    String data = "";
                    for (int j = i+key.length(); j < length; j++) {
                        if(Character.isDigit(formula.charAt(j))){
                            data += formula.charAt(j);
                            continue;
                        }
                        break;
                    }
                    Integer num = Integer.valueOf(data);
                    if(temp.containsKey(key)){
                        Integer originNum = temp.get(key);
                        temp.put(key,originNum + num*value);
                    }else {
                        temp.put(key,num*value);
                    }
                    i+=(key.length()+data.length());
                }else {
                    if(temp.containsKey(key)){
                        Integer originNum = temp.get(key);
                        temp.put(key,originNum + value);
                    }else {
                        temp.put(key,value);
                    }
                    i+=key.length();
                }

            }
            else if(formula.charAt(i) == '('){

                Stack<Character> s = new Stack<>();
                s.push('(');
                int index = i + 1;
                while (index < length && !s.isEmpty()){
                    if(formula.charAt(index) == ')'){
                        s.pop();
                    }
                    if(formula.charAt(index) == '('){
                        s.push('(');
                    }
                    index++;
                }
                String sub = formula.substring(i+1, index-1);
                int numLength = 0;
                int subValue = 1;
                if(Character.isDigit(formula.charAt(index))){
                    String data = "";
                    for (int j = index; j < length; j++) {
                        if(Character.isDigit(formula.charAt(j))){
                            data += formula.charAt(j);
                            continue;
                        }
                        break;
                    }
                    numLength = data.length();
                    subValue = Integer.valueOf(data);
                }
                function(sub,subValue*value);
                i+=(sub.length()+2+numLength);
            }

        }


    }


    /**
     * 分析一下：
     *      1.首先需要区分出全部元素
     *          如何区分？ 注意读题，原子总是以一个大写字母开始
     *      2.如何处理括号问题？
     *          栈的结构：入栈开始记录个数 出栈记录数乘以相应的数量
     *      3.递归解决问题
     *          从两头开始扫描 将问题规模缩小
     *          假设问题规模为 f(n)，其中n为括号数量，我们的目标就是不断缩小相应的括号数
     *          很容易推出 f(n) = f(n - 1)*系数
     *
     *
     * 具体实现：
     *      直接开始扫描
     *          1.遇到字母和数字的时候建立映射表
     *          2.遇到括号的时候，应该找到相应的右括号开始递归
     *          3.全局变量保存的为以前的数据，我们递归的数据应该临时变量保存
     *          4.递归出口为已经不在括号内部了
     */
}
