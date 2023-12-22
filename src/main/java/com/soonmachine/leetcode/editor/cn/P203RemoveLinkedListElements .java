//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
//
// Related Topics 递归 链表 👍 1373 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:移除链表元素

/**
 * 1. 双指针
 * 2. pre指针指向头节点的前一个节点，cur指针指向头节点
 * 3. 如果cur指针指向的节点的值等于val，pre指针的next指向cur指针的next，cur指针后移
 * 4. 如果cur指针指向的节点的值不等于val，pre指针后移，cur指针后移
 * 5. 重复3，4步骤，直到cur指针指向null
 * 6. 返回头节点
 * 时间复杂度：O(n)

 */
class P203RemoveLinkedListElements{
    public static void main(String[] args){
        Solution solution = new P203RemoveLinkedListElements().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode ans = pre;
        pre.next = head;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            }else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return ans.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}