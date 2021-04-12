package code0005;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {

        String s = "cbbd";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }

    //中心拓展法
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        // 1 首先找奇数位的 ： cabac
        for (int i = 0; i < chars.length; i++) {
            int preIndex = i - 1;
            int sufIndex = i + 1;
            while (preIndex >= 0 && sufIndex <chars.length && chars[preIndex] == chars[sufIndex]){
                preIndex --;
                sufIndex ++;
            }
            if (sufIndex - preIndex - 2 > end - start ){
                end = sufIndex - 1;
                start = preIndex + 1;
            }
        }

        // 2 查找偶数位 ：abccba
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != chars[i+1]){
                continue;
            }else{
                int preIndex = i - 1;
                int sufIndex = i + 2;
                while(preIndex >= 0 && sufIndex < chars.length && chars[preIndex] == chars[sufIndex]){
                    preIndex --;
                    sufIndex ++;
                }
                if (sufIndex - preIndex - 2 > end - start ){
                    end = sufIndex - 1;
                    start = preIndex + 1;
                }
            }
        }
        //查找结束  将数组转化为字符串返回
        return String.valueOf(chars, start, end-start+1);
    }
}
