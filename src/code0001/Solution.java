package code0001;

import java.util.*;

public class Solution {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     */
    public static void main(String[] args) {

        // int[] nums = {-1,-2,-3,-4,-5};
        int[] nums = {3,3};
        int target = 6;
        int[] ints = twoSum3(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        int first = -1;
        int second = -1;
        for (int i = 0 ; i < nums.length; i++){
            first = i;
            int result = target - nums[i];
            for (int j = 0 ; j < nums.length; j++){
                if (j == i){
                    continue;
                }
                if (nums[j] == result){
                    second = j;
                    break;
                }
            }
            if (second != -1){
                break;
            }
        }
        int[] result = {first, second};
        return result;
    }

    public static int[] twoSum3(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                result[0] = index;
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

}
