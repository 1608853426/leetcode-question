//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
//
//
// 0 <= j <= nums[i]
// i + j < n
//
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
//
//
//
// 示例 1:
//
//
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//
//
// 示例 2:
//
//
//输入: nums = [2,3,0,1,4]
//输出: 2
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 10⁴
// 0 <= nums[i] <= 1000
// 题目保证可以到达 nums[n-1]
//
//
// Related Topics 贪心 数组 动态规划 👍 2415 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:跳跃游戏 II

/**
 * 跳跃游戏 II
 * 1. 贪心
 * 贪心策略：统计两个边界，当前边界和下一次边界，遍历到当前边界时，下一次边界就是当前边界能到达的最远位置
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * <p>
 * 2. 动态规划
 * 与跳跃游戏I的动态规划思路一致，区别在于状态转移方程
 * 状态定义：dp[i]表示从第i个位置开始，到达最后一个位置的最小跳跃次数
 * 状态转移方程：dp[i] = min(dp[i+1],dp[i+2],...,dp[i+nums[i]]) + 1
 * 初始状态：dp[n-1] = 0
 * 返回值：dp[0]
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 */
class P45JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new P45JumpGameIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            if (nums.length == 1){
                return 0;
            }
            //贪心
            int ans = 0;
            int curEnd = 0;
            int curFarthest = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                curFarthest = Math.max(nums[i] + i, curFarthest);
                if (i == curEnd){
                    ans ++;
                    curEnd = curFarthest;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}