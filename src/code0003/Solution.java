package code0003;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        String s = " ";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> hMap = new HashMap<>();
        int result = 0;
        int max = 0;
        if (s == null || "".equals(s)){
            return 0;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hMap.get(chars[i]) == null){
                hMap.put(chars[i], i);
                result += 1;
                if (max < result){
                    max = result;
                }
                continue;
            }
            if (hMap.get(chars[i]) == chars.length - 1){
                break;
            }
            i = hMap.get(chars[i]);
            hMap.clear();
            result = 0;
        }
        return max;
    }
}
