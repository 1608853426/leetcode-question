//给你一个非负整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 1815 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:目标和

/**
 * 目标和
 * 解法一：回溯
 * 1. 递归终止条件：遍历完数组
 * 2. 递归过程：对数组中的每个元素都有两种选择，加或者减
 * 3. 递归返回值：返回所有可能的结果
 * 时间复杂度：O(2^n)，其中 n 是数组 nums 的长度。
 * 解法二：动态规划
 * 1. 用一个二维数组 dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数
 * 2. 状态转移方程：dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
 * 3. 边界条件：dp[0][0] = 1
 * 4. 最终答案：dp[n][target]
 * 时间复杂度：O(n * sum)，其中 n 是数组 nums 的长度，sum 是数组 nums 中元素的和。
 */
class P494TargetSum{
    public static void main(String[] args){
        Solution solution = new P494TargetSum().new Solution();
        // TO TEST
        int[] nums = new int[]{2,107,109,113,127,131,137,3,2,3,5,7,11,13,17,19,23,29,47,53};
        int target = 1000;
        System.out.println(solution.findTargetSumWays(nums, target));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // 背包容量
        // 由于数组中所有数的和不超过 1000，那么这个数组的和最大为 1000，而数组中的数非负，因此这个数组中的数最小为 0。
        // 那么 sum 的范围为 [0,1000]，target 的范围为 [-1000,1000]，那么 sum + target 的范围为 [0,2000]。
        // 因此我们可以定义一个二维数组 dp，其中 dp[i][j] 表示在数组 nums 的前 i 个数中选取元素，使得这些元素之和等于 j 的方案数。
        // 注意到如果 sum + target 是奇数，那么就不存在方案，因此可以直接返回 0。
        // 如果 sum + target 是偶数，那么需要计算出原问题的一个子问题：找到一个子集 P，使得这个子集中元素之和等于 (sum + target) / 2。
        // 这样原问题就转化为：在数组 nums 中选取若干元素，使得这些元素之和等于 (sum + target) / 2。
        // 可以使用动态规划的方法求解。
        // dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
        // dp[i][j] 表示在数组 nums 的前 i 个数中选取元素，使得这些元素之和等于 j 的方案数。
        // dp[i - 1][j - nums[i]] 表示在数组 nums 的前 i - 1 个数中选取元素，使得这些元素之和等于 j - nums[i] 的方案数。
        // dp[i - 1][j + nums[i]] 表示在数组 nums 的前 i - 1 个数中选取元素，使得这些元素之和等于 j + nums[i] 的方案数。
        // dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
        // 边界条件：dp[0][0] = 1
        // 最终答案：dp[n][target]
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if((sum + target) % 2 == 1 || sum < target){
            return 0;
        }
        int n = nums.length;
        // neg 表示符号为 - 的元素之和，那么其余元素之和就是 sum - neg，需要注意的是，neg 是一个负数
        // 和为neg的方案数即为答案，转化为背包问题，背包容量为neg
        int neg = (sum - target) / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            int num = nums[i - 1];
            for(int j = 0; j <= neg; j++){
                dp[i][j] = dp[i - 1][j];
                if(j >= num){
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}