package zju.cst.hl.interview;

import java.math.BigInteger;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Number_8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("2147483646"));

    }

    public static int myAtoi(String str) {

        if(str == null){
            return 0;
        }
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }
        if(!(Character.isDigit(str.charAt(0)) || str.charAt(0) == '-' || str.charAt(0) == '+')){
            return 0;
        }
        int length = str.length();
        boolean flag = true;
        for (int i = 0; i < length ; i++) {
            if(flag && (Character.isDigit(str.charAt(i)) || str.charAt(i) == '-' || str.charAt(i) == '+')){
                flag = false;
            }
            if(!flag){
                int exp = 1;
                String value = "";
                for (int j = i; j < length; j++) {
                    char c = str.charAt(j);
                    if(j == i){
                        if(c == '-'){
                            exp = -1;
                            continue;
                        }
                        if(c == '+'){
                            exp = 1;
                            continue;
                        }
                    }
                    if(Character.isDigit(c)){
                        value += c;
                    }else {
                        break;
                    }
                }
                /*BigInteger num = new BigInteger(value);
                if(num.compareTo(new BigInteger(Integer.MIN_VALUE + "")) < 0){
                    return Integer.MIN_VALUE;
                }
                if(num.compareTo(new BigInteger(Integer.MAX_VALUE + "")) > 0){
                    return Integer.MAX_VALUE;
                }
                return Integer.valueOf(num.toString())*exp;*/
                int index = 0;
                for (int j = 0; j < value.length(); j++) {
                    if(value.charAt(j) == '0'){
                        index = j;
                        continue;
                    }else {
                        break;
                    }
                }
                value = value.substring(index);
                if(value.length() == 0){
                    return 0;
                }
                if(value.length() > 10){
                    if(exp == 1){
                        return Integer.MAX_VALUE;
                    }else {
                        return Integer.MIN_VALUE;
                    }
                }
                long num = Long.parseLong(value)*exp;
                if(num > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if(num < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                return (int)num;
            }
        }
        return 0;
    }



}
