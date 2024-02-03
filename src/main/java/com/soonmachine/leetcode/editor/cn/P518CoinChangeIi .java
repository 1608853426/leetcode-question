//给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。 
//
// 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。 
//
// 假设每一种面额的硬币有无限个。 
//
// 题目数据保证结果符合 32 位带符号整数。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：amount = 5, coins = [1, 2, 5]
//输出：4
//解释：有四种方式可以凑成总金额：
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2： 
//
// 
//输入：amount = 3, coins = [2]
//输出：0
//解释：只用面额 2 的硬币不能凑成总金额 3 。
// 
//
// 示例 3： 
//
// 
//输入：amount = 10, coins = [10] 
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 300 
// 1 <= coins[i] <= 5000 
// coins 中的所有值 互不相同 
// 0 <= amount <= 5000 
// 
//
// Related Topics 数组 动态规划 👍 1219 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:零钱兑换 II

import java.util.Arrays;

/**
 * 零钱兑换 II
 * 解法一：动态规划
 * 1. 用一个二维数组 dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数
 * 2. 状态转移方程：dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]]
 * 3. 边界条件：dp[0][0] = 1
 * 4. 最终答案：dp[n][amount]
 * 时间复杂度：O(n * amount)，其中 n 是数组 coins 的长度。
 */
class P518CoinChangeIi {
    public static void main(String[] args) {
        Solution solution = new P518CoinChangeIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                int value = coins[i - 1];
                for (int j = 0; j <= amount; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= value) {
                        dp[i][j] += dp[i][j - value];
                    }
                }
            }
            return dp[n][amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}