package code0004;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2,3};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int mid = -1;
        int flag = 0; // 0 表示取一位， 1 取两位平均值
        // 计算要取一位还是两位
        int length = nums1.length + nums2.length;
        if (length % 2 == 0){
            flag = 1;
            mid = mid = length / 2;
        }else{
            mid = length / 2 + 1;
        }

        double result = 0;
        for(int i = 1; i <= mid; i++){
            if (p1 < nums1.length && p2 < nums2.length && i != mid){
                if (nums1[p1] <= nums2[p2]){
                    p1++;
                }else{
                    p2++;
                }
            }else if (p1 == nums1.length && p2 < nums2.length && i != mid){
                p2++;
            }else if (p1 < nums1.length && p2 == nums2.length && i != mid){
                p1++;
            }else if(i == mid){
                // 单个值
                if (flag == 0){
                    if (p1 < nums1.length && p2 < nums2.length){
                        if (nums1[p1] <= nums2[p2])
                            result = nums1[p1];
                        else
                            result = nums2[p2];
                    }else if (p1 == nums1.length){
                        result = nums2[p2];
                    }else if (p2 == nums2.length){
                        result = nums1[p1];
                    }
                }else{
                    // 两个值
                    for (int j = 0; j <2 ; j++) {
                        if (p1 < nums1.length && p2 < nums2.length){
                            if (nums1[p1] <= nums2[p2]){
                                result += nums1[p1];
                                p1 ++;
                            }else {
                                result += nums2[p2];
                                p2 ++;
                            }
                        }else if (p1 == nums1.length){
                            result += nums2[p2];
                            p2++;
                        }else if (p2 == nums2.length){
                            result += nums1[p1];
                            p1++;
                        }
                    }
                    result = result / 2;
                }
            }
        }
        return result;
    }

}
