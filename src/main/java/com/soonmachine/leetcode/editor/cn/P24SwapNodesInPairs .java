//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 2113 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:两两交换链表中的节点

/**
 * 两两交换链表中的节点
 * 1. 递归
 * 递归的终止条件是链表中没有节点，或者链表中只有一个节点，此时无法进行交换。
 * 如果链表中至少有两个节点，则在两两交换链表中的节点之后，原始链表的头节点变成新的链表的第二个节点，原始链表的第二个节点变成新的链表的头节点。
 * 链表中的其余节点的两两交换可以递归地实现。在对链表中的其余节点递归地两两交换之后，更新节点之间的指针关系，即可完成整个链表的两两交换。
 * 具体而言，新的链表中的头节点是原始链表中的第二个节点，新的链表中的第二个节点是原始链表中的头节点，以此类推。
 * 需要返回新的链表的头节点。
 * 时间复杂度：O(n)，其中 n 是链表的节点数量。需要对每个节点进行更新指针的操作。
 * 2. 迭代
 * 创建一个新的节点，作为头节点，然后迭代原始链表。
 * 每次迭代到原始链表的两个节点时，先将新节点的下一个节点指向第二个节点，再将第一个节点的下一个节点指向第三个节点，最后将第二个节点的下一个节点指向第一个节点。
 * 时间复杂度：O(n)，其中 n 是链表的节点数量。需要对每个节点进行更新指针的操作。
 * 空间复杂度：O(1)。
 */
class P24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
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
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }
            ListNode dump = new ListNode(-1, head);
            ListNode cur = dump;
            while (cur.next != null && cur.next.next != null){
                ListNode first = cur.next;
                ListNode second = cur.next.next;
                ListNode third = cur.next.next.next;
                cur.next = second;
                second.next = first;
                first.next = third;
                cur = first;
            }
            return dump.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}