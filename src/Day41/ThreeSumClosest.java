package Day41;

import java.util.Arrays;

/*
16. 最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
找出 nums 中的三个整数，使得它们的和与 target 最接近。
返回这三个数的和。
假定每组输入只存在唯一答案。

示例：
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

https://leetcode-cn.com/problems/3sum-closest/

 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int len = nums.length;
        if (len < 3) throw new IllegalArgumentException("数组元素错误");
        Arrays.sort(nums);//排序
        int closet = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {//定 2 寻 1
            if (i > 0 && nums[i] == nums[i-1]) continue;//去重
            int L = i + 1;
            int R = len -1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if ((sum - target) > 0){
                    if (Math.abs(sum - target) < closet){
                        closet = Math.abs(sum - target);
                        res = sum;
                        while ( L < R && nums[R] == nums[R-1]) R--;//去重
                        R--;
                    }else {
                        while ( L < R && nums[R] == nums[R-1]) R--;//去重
                        R--;
                    }
                } else if ((sum - target) < 0){
                    if (Math.abs(sum - target) < closet){
                        closet = Math.abs(sum - target);
                        res = sum;
                        while ( L < R && nums[L] == nums[L+1]) L++;//去重
                        L++;
                    }else {
                        while ( L < R && nums[L] == nums[L+1]) L++;//去重
                        L++;
                    }
                } else if ((sum - target) == 0){
                    return sum;
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = {0,2,1,-3};
        System.out.println(threeSumClosest(nums,1));
    }

}
