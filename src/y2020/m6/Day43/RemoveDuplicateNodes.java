package y2020.m6.Day43;
/*

面试题 02.01. 移除重复节点
编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

示例1:
 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
示例2:
 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]
提示：
链表长度在[0, 20000]范围内。
链表元素在[0, 20000]范围内。
进阶：
如果不得使用临时缓冲区，该怎么解决？

https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 */


import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodes {
    private Set<Integer> hashSet = new HashSet<>();

    //哈希表
    private ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        if (cur != null){
            set.add(cur.val);
        }
        while (cur != null && cur.next != null){

            if (!set.add(cur.next.val)){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }


    //递归方法
    private ListNode circle(ListNode head){
        if (head == null){
            return null;
        }
        if (hashSet.contains(head.val)){
            return circle(head.next);
        }
        hashSet.add(head.val);
        head.next = circle(head.next);
        return head;
    }


}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}