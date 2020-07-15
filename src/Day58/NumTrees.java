package Day58;

/*

96. 不同的二叉搜索树
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:
输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

https://leetcode-cn.com/problems/unique-binary-search-trees/

 */

public class NumTrees {
    /*
    ===================
       solution 1 dp
    ===================
     */
    //https://leetcode-cn.com/problems/unique-binary-search-trees/solution/shou-hua-tu-jie-san-chong-xie-fa-dp-di-gui-ji-yi-h/
    public int numTrees(int n) {
        int[] dp =new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }

    /*
    =====================
        solution 2 math
    =====================
     */
    //https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/
    public int numTrees1(int n) {
        long res = 1;
        for (int i = 0; i < n; i++) {
            res = res * 2 * (2 * i + 1) / (i+2);
        }
        return (int) res;
    }
}
