//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics 栈 数组 单调栈 👍 1656 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.Stack;

//java:每日温度
class P739DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new P739DailyTemperatures().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 单调栈
         * @param temperatures 73,74,75,71,69,72,76,73
         * @ return 1,1,4,2,1,1,0,0
         * 单调栈的思想：栈中元素单调递减，当遇到比栈顶元素大的元素时，栈顶元素出栈，直到栈顶元素大于当前元素，当前元素入栈
         * https://www.acwing.com/solution/content/27437/
         */
        public int[] dailyTemperatures(int[] temperatures) {
            /*Stack<Integer> stack = new Stack<>();
            int[] res = new int[temperatures.length];
            for (int i = temperatures.length - 1; i >= 0; i--) {
                while (!stack.empty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                res[i] = stack.empty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return res;*/
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[temperatures.length];
            for (int i = temperatures.length - 1; i >= 0; i --){
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}