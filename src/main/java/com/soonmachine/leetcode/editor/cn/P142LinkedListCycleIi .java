//给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 不允许修改 链表。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
//
// 
//
// 进阶：你是否可以使用 O(1) 空间解决此题？ 
//
// Related Topics 哈希表 链表 双指针 👍 2423 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:环形链表 II

/**
 * 首先我们分析一下两个指针相遇的时候，这个快指针走了几圈？
 * 假设链表的头节点到环形入口节点的距离为 a，快慢指针相遇在距离环形入口节点 b 的位置，环形的周长为 L。
 * 当快慢指针相遇的时候，假设慢指针 slow 走了 n 步，那么快指针 fast 一定走了 2n 步，也就是说比 slow 多走了 n 步（也就是环形的周长）。
 * 2n = n + kL => n = kL
 * a = kL - b = (k-1)L + (L - b)
 * a 的长度等于 (k-1) 倍的环形长度，加上 L-b 的长度
 * L-b 的长度恰好等于从相遇点到环形入口的长度
 * 所以，当快慢指针相遇的时候，我们再额外使用一个指针 ptr。起始，它指向链表的头节点；随后，它和 slow 每次向后移动一个位置。
 * 最终，它们会在入环点相遇。
 */
class P142LinkedListCycleIi{
    public static void main(String[] args){
        Solution solution = new P142LinkedListCycleIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == null){
                return null;
            }
            if (fast == slow){
                ListNode ans = head;
                while (ans != fast){
                    ans = ans.next;
                    fast = fast.next;
                }
                return ans;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}