package Day56;
/*

350. 两个数组的交集 II
给定两个数组，编写一个函数来计算它们的交集。

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]

示例 2:
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]


说明：
输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
我们可以不考虑输出结果的顺序。

进阶：
如果给定的数组已经排好序呢？你将如何优化你的算法？

如果 nums1 的大小比 nums2 小很多，哪种方法更优？

如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，
并且你不能一次加载所有的元素到内存中，你该怎么办？


https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/

 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        int lenA = nums1.length;
        int lenB = nums2.length;
        if (lenA > lenB){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums1) {
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i,count);
        }
        int[] res = new int[lenA];
        int index = 0;
        for (int i : nums2) {
            int count = map.getOrDefault(i,0);
            if (count > 0){
                res[index++] = i;
                count--;
                if (count > 0 ){
                    map.put(i,count);
                }else {
                    map.remove(i);
                }
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0 , j = 0,index = 0;
        int[] res = new int[Math.min(nums1.length,nums2.length)];
        while (i < nums1.length && j < nums2.length){
             int a = nums1[i];
             int b = nums2[j];
             if (a == b){
                res[index++] = a;
                i++;
                j++;
             }else if (a > b){
                 j++;
             }else {
                 i++;
             }
        }
        return Arrays.copyOfRange(res,0,index);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        Intersect intersect = new Intersect();
        intersect.intersect1(nums1,nums2);
    }
}
