//请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
//
// 实现 MyStack 类：
//
//
// void push(int x) 将元素 x 压入栈顶。
// int pop() 移除并返回栈顶元素。
// int top() 返回栈顶元素。
// boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
//
//
//
//
// 注意：
//
//
// 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
// 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
//
//
//
//
// 示例：
//
//
//输入：
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 2, 2, false]
//
//解释：
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // 返回 2
//myStack.pop(); // 返回 2
//myStack.empty(); // 返回 False
//
//
//
//
// 提示：
//
//
// 1 <= x <= 9
// 最多调用100 次 push、pop、top 和 empty
// 每次调用 pop 和 top 都保证栈不为空
//
//
//
//
// 进阶：你能否仅用一个队列来实现栈。
//
// Related Topics 栈 设计 队列 👍 825 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Queue;

//java:用队列实现栈

/**
 * 用队列实现栈
 * 用一个队列实现栈
 * 1. push(x)：入队前将队列中的元素依次出队，然后将新元素入队，再将所有元素依次入队；
 * 2. pop()：直接将队首元素出队；
 * 3. top()：直接返回队首元素；
 * 4. empty()：判断队列是否为空。
 *
 */
class P225ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack solution = new P225ImplementStackUsingQueues().new MyStack();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {
        Queue<Integer> queue;
        public MyStack() {
            queue = new ArrayDeque<>();
        }

        public void push(int x) {
            queue.add(x);
            int time = queue.size() - 1;
            while (time -- > 0){
                queue.add(queue.poll());
            }
        }

        public int pop() {
            int ans = 0;
            if (!queue.isEmpty()){
                ans = queue.poll();
            }
            return ans;
        }

        public int top() {
            int ans = 0;
            if (!queue.isEmpty()){
                ans = queue.peek();
            }
            return ans;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}