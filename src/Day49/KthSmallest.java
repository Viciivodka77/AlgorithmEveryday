package Day49;

import java.util.Arrays;

/*
378. 有序矩阵中第K小的元素
给定一个 n x n 矩阵，
其中每行和每列元素均按升序排序，
找到矩阵中第 k 小的元素。
请注意，它是排序后的第 k 小元素，
而不是第 k 个不同的元素。

示例：
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,
返回 13。

提示：
你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。

https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/

 */
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                res[index++] = num;
            }
        }
        Arrays.sort(res);
        return res[k-1];
    }

    //二分
    public int kthSmallest1(int[][] matrix, int k) {
        int len = matrix.length;
        int left = matrix[0][0];
        int right = matrix[len-1][len-1];
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if (check(matrix,mid,k,len)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    private boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n-1;
        int j = 0;
        int num = 0;
        while ( i >= 0 && j < n){
            if (matrix[i][j] <= mid){
                num += i+1;
                j++;
            }else {
                i--;
            }
        }
        return num >= k;
    }


}
