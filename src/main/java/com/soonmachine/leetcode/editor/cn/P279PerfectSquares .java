//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数学 动态规划 👍 1904 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:完全平方数
class P279PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new P279PerfectSquares().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            int maxNum = (int) (Math.sqrt(n) + 1);
            List<Integer> squaresList = new ArrayList<>();
            for (int i = 1; i < maxNum; i++) {
                squaresList.add(i * i);
            }
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int x : squaresList) {
                    if (i >= x && dp[i - x] != -1) {
                        if (dp[i] == -1) {
                            dp[i] = dp[i - x] + 1;
                        } else {
                            dp[i] = Math.min(dp[i], dp[i - x] + 1);
                        }
                    }
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}