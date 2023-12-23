//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。 
//
// 图示两个链表在节点 c1 开始相交： 
//
// 
//
// 题目数据 保证 整个链式结构中不存在环。 
//
// 注意，函数返回结果后，链表必须 保持其原始结构 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, 
//skipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 
//1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
// 
//
// 
//
// 提示： 
//
// 
// listA 中节点数目为 m 
// listB 中节点数目为 n 
// 0 <= m, n <= 3 * 10⁴ 
// 1 <= Node.val <= 10⁵ 
// 0 <= skipA <= m 
// 0 <= skipB <= n 
// 如果 listA 和 listB 没有交点，intersectVal 为 0 
// 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1] 
// 
//
// 
//
// 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？ 
//
// Related Topics 哈希表 链表 双指针 👍 417 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:链表相交

/**
 *  链表相交
 *  1. 交点不是数值相等，而是指针相等。
 *  2. 两个链表长度可能不相等，但是两个链表相交后的长度一定相等。
 *  3. 我们求出两个链表的长度，并求出两个链表长度的差值，然后让curA移动到，和curB 末尾对齐的位置
 *  4. 然后让curA和curB同时移动，直到curA和curB相等，此时的节点就是交点。
 *  时间复杂度：O(m+n)
 *  空间复杂度：O(1)
 */

class IntersectionOfTwoLinkedListsLcci{
    public static void main(String[] args){
        Solution solution = new  IntersectionOfTwoLinkedListsLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        int lenFirst = 0, lenSecond = 0;
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (tmpA != null){
            lenFirst ++;
            tmpA = tmpA.next;
        }
        while (tmpB != null){
            lenSecond ++;
            tmpB = tmpB.next;
        }
        tmpA = headA;
        tmpB = headB;
        if (lenFirst >= lenSecond){
            int tmp = lenFirst - lenSecond;
            while (tmp -- > 0){
                tmpA = tmpA.next;
            }
        }else {
            int tmp = lenSecond - lenFirst;
            while (tmp -- > 0){
                tmpB = tmpB.next;
            }
        }
        while (tmpA != null && tmpB != null){
            if (tmpA == tmpB){
                return tmpA;
            }
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}