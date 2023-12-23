//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2768 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:删除链表的倒数第 N 个结点


/**
 * 删除链表的倒数第 N 个结点
 * 双指针
 * 一次遍历
 * 1. 定义两个指针，第一个指针从列表的开头向前移动 n+1 步，而第二个指针将从列表的开头出发。
 * 2. 现在，这两个指针被 n 个结点分开。
 * 3. 我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。
 * 4. 此时第二个指针将指向从最后一个结点数起的第 n 个结点。
 * 5. 我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
 * 时间复杂度：O(L)，其中 L 是链表的长度。
 * 空间复杂度：O(1)。
 */
class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) {
                return null;
            }
            ListNode dump = new ListNode(-1, head);
            ListNode fast = dump;
            ListNode slow = dump;

            //fast先走n+1步
            while (n-- >= 0) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dump.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}