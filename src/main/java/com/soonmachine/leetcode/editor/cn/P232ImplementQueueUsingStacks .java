//请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）： 
//
// 实现 MyQueue 类： 
//
// 
// void push(int x) 将元素 x 推到队列的末尾 
// int pop() 从队列的开头移除并返回元素 
// int peek() 返回队列开头的元素 
// boolean empty() 如果队列为空，返回 true ；否则，返回 false 
// 
//
// 说明： 
//
// 
// 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法
//的。 
// 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["MyQueue", "push", "push", "peek", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 1, 1, false]
//
//解释：
//MyQueue myQueue = new MyQueue();
//myQueue.push(1); // queue is: [1]
//myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
//myQueue.peek(); // return 1
//myQueue.pop(); // return 1, queue is [2]
//myQueue.empty(); // return false
// 
//
// 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x <= 9 
// 最多调用 100 次 push、pop、peek 和 empty 
// 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作） 
// 
//
// 
//
// 进阶： 
//
// 
// 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。 
// 
//
// Related Topics 栈 设计 队列 👍 1037 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:用栈实现队列

import java.util.Stack;

/**
 * 用栈实现队列
 * 1. 用两个栈，一个输入栈，一个输出栈
 * 2. push() 方法，直接将元素压入输入栈
 * 3. pop() 方法，如果输出栈为空，就将输入栈的元素全部弹出并压入输出栈，然后输出栈弹出栈顶元素
 * 4. peek() 方法，如果输出栈为空，就将输入栈的元素全部弹出并压入输出栈，然后输出栈返回栈顶元素
 * 5. empty() 方法，如果输入栈和输出栈都为空，就返回true，否则返回false
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class P232ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue solution = new P232ImplementQueueUsingStacks().new MyQueue();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {
        Stack<Integer> input;
        Stack<Integer> output;

        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            if (this.empty()){
                return 0;
            }
            if (output.empty()){
                while (!input.empty()){
                    output.push(input.pop());
                }
            }
            return output.pop();
        }

        public int peek() {
            if (this.empty()){
                return 0;
            }
            if (output.empty()){
                while (!input.empty()){
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        public boolean empty() {
            return input.empty() && output.empty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}