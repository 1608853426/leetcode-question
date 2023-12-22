//你可以选择使用单链表或者双链表，设计并实现自己的链表。 
//
// 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。 
//
// 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。 
//
// 实现 MyLinkedList 类： 
//
// 
// MyLinkedList() 初始化 MyLinkedList 对象。 
// int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。 
// void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。 
// void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。 
// void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 
//index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。 
// void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", 
//"deleteAtIndex", "get"]
//[[], [1], [3], [1, 2], [1], [1], [1]]
//输出
//[null, null, null, null, 2, null, 3]
//
//解释
//MyLinkedList myLinkedList = new MyLinkedList();
//myLinkedList.addAtHead(1);
//myLinkedList.addAtTail(3);
//myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
//myLinkedList.get(1);              // 返回 2
//myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
//myLinkedList.get(1);              // 返回 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= index, val <= 1000 
// 请不要使用内置的 LinkedList 库。 
// 调用 get、addAtHead、addAtTail、addAtIndex 和 deleteAtIndex 的次数不超过 2000 。 
// 
//
// Related Topics 设计 链表 👍 978 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:设计链表


/**
 * 设计链表
 * 1. 单链表
 * 2. head指针指向头节点
 * 3. size指针指向链表长度
 * 4. get方法：如果index大于等于size，返回-1；如果index小于size，遍历链表，直到index为0，返回当前节点的值
 * 5. addAtHead方法：head指针指向新节点，新节点的next指针指向原来的头节点，size加1
 * 6. addAtTail方法：遍历链表，直到当前节点的next指针指向null，当前节点的next指针指向新节点，size加1
 * 7. addAtIndex方法：如果index大于size，直接返回；如果index等于size，调用addAtTail方法；如果index小于size，遍历链表，直到index为0，当前节点的next指针指向新节点，新节点的next指针指向当前节点的next指针指向的节点，size加1
 * 8. deleteAtIndex方法：如果index大于等于size，直接返回；如果index等于0，head指针指向head指针指向的节点，size减1；如果index小于size，遍历链表，直到index为1，当前节点的next指针指向当前节点的next指针指向的节点的next指针指向的节点，size减1
 * 时间复杂度：O(n)
 */
class P707DesignLinkedList {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
     class ListNode {
        int val;

        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class MyLinkedList {

        ListNode head;

        Integer size;

        public MyLinkedList() {
            this.head = new ListNode(0);
            this.size = 0;
        }

        public int get(int index) {
            if (index >= size) {
                return -1;
            }
            ListNode tmp = head;
            while (index-- >= 0) {
                tmp = tmp.next;
            }
            return tmp.val;
        }

        public void addAtHead(int val) {
            ListNode realHead = head.next;
            head.next = new ListNode(val, realHead);
            size++;
        }

        public void addAtTail(int val) {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new ListNode(val);
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }
            ListNode pre = head;
            ListNode cur = head.next;
            while (index-- > 0) {
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = new ListNode(val, cur);
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size) {
                return;
            }
            ListNode pre = head;
            ListNode cur = head.next;
            while (index-- > 0) {
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = cur.next;
            size--;

        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}