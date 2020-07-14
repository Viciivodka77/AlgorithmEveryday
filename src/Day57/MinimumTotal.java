package Day57;

/*
120. 三角形最小路径和
给定一个三角形，找出自顶向下的最小路径和。
每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

例如，给定三角形：
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：
如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

https://leetcode-cn.com/problems/triangle/

 */
import Day56.Intersect;

import java.util.List;

public class MinimumTotal {

    /*
    ===============================
       solution1     递归+记忆体
    ===============================
     */
    private Integer[][] memory ;

    public int minimumTotal(List<List<Integer>> triangle) {
        memory = new Integer[triangle.size()][triangle.size()];
        return dfs(triangle,0,0);
    }
    private int dfs(List<List<Integer>> triangle, int i, int j){
        if (i == triangle.size()){
            return 0;
        }
        if (memory[i][j] != null){
            return memory[i][j];
        }
        return memory[i][j]  = Math.min(dfs(triangle,i+1,j),dfs(triangle,i+1,j+1)) + triangle.get(i).get(j);
    }

    /*
    ===============================
       solution2     dp
    ===============================
     */

    public int minimumTotal1(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i+1][j] , dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /*
    ===============================
       solution3     dp优化
    ===============================
     */

    public int minimumTotal2(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j] , dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

}
