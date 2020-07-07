package Day52;
/*
112. 路径总和
给定一个二叉树和一个目标和，
判断该树中是否存在根节点到叶子节点的路径，
这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

https://leetcode-cn.com/problems/path-sum/
 */

public class HasPathSum {
    //1
    public boolean hasPathSum(TreeNode root, int sum) {
        return help(root,0,sum);
    }
    private boolean help(TreeNode root, int cur, int sum){
        if (root == null) return false;
        cur += root.val;
        if (root.left == null && root.right == null){
            return cur == sum;
        }else {
            return help(root.left,cur,sum) || help(root.right,cur,sum);
        }
    }
    //2
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}