package zju.cst.hl.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
public class Number_13 {
    public static void main(String[] args) {

        System.out.println(romanToInt("MCDLXXVI"));

    }



    public static int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        int result = 0;
        for (int i = 0; i < s.length();) {
            if(i+2 <= s.length()){
                String sub = s.substring(i,i+2);
                if(map.containsKey(sub)){
                    result += map.get(sub);
                    i+=2;
                    System.out.println(map.get(sub));
                    continue;
                }
            }
            String sub = s.substring(i,i+1);
            result += map.get(sub);
            System.out.println(map.get(sub));
            i++;
        }
        return result;
    }


    /**
     * 本质上就是一个模拟题，并没有太多思想，把情况考虑到位就行了
     */
}
