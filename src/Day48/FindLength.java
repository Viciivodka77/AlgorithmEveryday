package Day48;

/*
718. 最长重复子数组
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

示例：
输入：
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出：3
解释：
长度最长的公共子数组是 [3, 2, 1] 。

提示：
1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100

https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/

 */

import java.util.Arrays;

public class FindLength {

    //暴力    （超时
    public int findLength(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int res = 0;
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                if (A[i] == B[j]){
                    int len = 1;
                    while (i + len < lenA && j + len < lenB && A[i+len] == B[j+len]  ){
                        len++;
                    }
                    res = Math.max(res,len);
                }
            }
        }
        return res;
    }

    //dp
    private static int findLength1(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int[][] dp = new int[lenA+1][lenB+1];
        //初始化
        for (int i = 0; i < lenA + 1; i++) {
            Arrays.fill(dp[i],0);
        }
        int res = 0;
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {2,3,5,45,5,3};
        int[] B = {2,1,3,25,4,5,8,3};
        int length1 = findLength1(A, B);
        System.out.println(length1);
    }

}
