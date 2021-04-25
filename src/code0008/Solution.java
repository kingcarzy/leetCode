package code0008;

import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        String s  = "+1";
        int i = myAtoi(s);
        System.out.println("result:"+i);
    }

    public static int myAtoi(String s) {
        String trim = s.trim();
        String patten = "^[-\\+]?[\\d]+.*$";
        Pattern compile = Pattern.compile(patten);
        boolean isValidate = compile.matcher(trim).matches();
        StringBuilder stringBuilder ;
        if (isValidate){
            int i = 0;
            stringBuilder = new StringBuilder();
            char[] chars = trim.toCharArray();
            if (chars[0] == '-' || chars[0] == '+'){
                i = 1;
                stringBuilder.append(chars[0]);
            }
            for (; i < chars.length ; i++) {
                if(Character.isDigit(chars[i])){
                    stringBuilder.append(chars[i]);
                }else {
                    break;
                }
            }
        }else {
            return 0;
        }
        String sValue = stringBuilder.toString();
        try {
            int result = Integer.parseInt(sValue);
            return result;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            if (sValue.startsWith("-")){
                return -2147483648;
            }else {
                return 2147483647;
            }
        }
    }

}
