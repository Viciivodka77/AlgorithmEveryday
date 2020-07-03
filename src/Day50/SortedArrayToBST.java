package Day50;

/*
108. 将有序数组转换为二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。

示例:
给定有序数组: [-10,-3,0,5,9],
一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
      0
     / \
   -3   9
   /   /
 -10  5


 */

import java.util.zip.Deflater;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length-1);
    }


    private TreeNode dfs(int[] nums, int l, int h) {
        if (l > h) return null;
        int mid = l + ((h-l)>>1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,l,mid-1);
        root.right = dfs(nums,mid + 1 ,h);
        return root;
    }


}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}