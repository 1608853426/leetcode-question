//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2652 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:滑动窗口最大值
/**
 * 单调队列
 * 1. 队列中存储的是元素的下标
 * 2. 队列中的元素是单调递减的
 * 3. 队头元素就是滑动窗口中的最大值
 * 4. 队列中的元素个数不会超过k
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

class P239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            MonotonicQueue queue = new MonotonicQueue();
            int[] res = new int[nums.length - k + 1];
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i < k - 1){
                    queue.push(nums[i]);
                }else {
                    queue.push(nums[i]);
                    res[index ++] = queue.peek();
                    queue.pop(nums[i - k + 1]);
                }
            }
            return res;
        }

        class MonotonicQueue {
            // 单调队列
            Deque<Integer> deque = new LinkedList<>();
            // 入队
            // 1. 如果队列不为空，就将队列中小于当前元素的元素全部出队
            // 2. 将当前元素入队
            void push(int n){
                while (!deque.isEmpty() && deque.peekLast() < n){
                    deque.pollLast();
                }
                deque.addLast(n);
            }

            // 出队
            // 1. 如果队列不为空，就将队头元素出队
            // 2. 如果出队的元素等于队头元素，就将队头元素出队
            void pop(int n ){
                if (!deque.isEmpty() && deque.peekFirst() == n){
                    deque.pollFirst();
                }
            }

            // 获取队列中的最大值
            int peek(){
                return deque.isEmpty() ? 0: deque.peekFirst();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}