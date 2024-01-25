//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。
//
// 示例 2：
//
//
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
//
//
// Related Topics 数组 动态规划 👍 1975 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:分割等和子集

import java.util.Arrays;

/**
 * 分割等和子集
 * 1. 动态规划 01背包问题
 * 1.1 状态定义：dp[i][j]表示前i个元素中是否存在和为j的子集
 * 1.2 状态转移方程：dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]] (j>=nums[i])
 * 1.3 初始化：dp[0][0] = true, dp[0][j] = false, dp[i][0] = true
 * 1.4 结果：dp[n][sum], sum为数组元素和的一半
 * 时间复杂度：O(n*sum)
 * 空间复杂度：O(n*sum)
 */
class P416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new P416PartitionEqualSubsetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 != 0) {
                return false;
            }
            sum = sum / 2;
            boolean[][] dp = new boolean[nums.length + 1][sum + 1];
            dp[0][0] = true;
            for (int i = 1; i <= nums.length; i++) {
                int num = nums[i - 1];
                for (int j = 1; j <= sum; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= num) {
                        dp[i][j] |= dp[i - 1][j - num];
                    }
                }
            }
            return dp[nums.length][sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}