//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2638 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:跳跃游戏

/**
 * 跳跃游戏
 * 1. 贪心
 * 贪心策略：从第一个位置开始，每次都选择可以跳跃的最远位置
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * 2. 动态规划
 * 状态定义：dp[i]表示从第i个位置开始，能否到达最后一个位置
 * 状态转移方程：dp[i] = dp[i+1] || dp[i+2] || ... || dp[i+nums[i]]
 * 初始状态：dp[n-1] = true
 * 返回值：dp[0]
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 */
class P55JumpGame {
    public static void main(String[] args) {
        Solution solution = new P55JumpGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length == 1) {
                return true;
            }
            int count = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (--count < 0){
                    return false;
                }
                count = Math.max(count, nums[i]);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}