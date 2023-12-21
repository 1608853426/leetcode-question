//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返
//回其长度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 2001 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:长度最小的子数组
/**
 * 1. 滑动窗口
 * 2. left指针指向数组头部，right指针指向数组尾部
 * 3. right指针向右移动，直到满足sum >= target
 * 4. left指针向右移动，直到sum < target
 * 5. 重复3，4步骤，直到right指针到达数组尾部
 * 6. 返回最小长度
 * 时间复杂度：O(n)
 */
class P209MinimumSizeSubarraySum{
    public static void main(String[] args){
        Solution solution = new P209MinimumSizeSubarraySum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int curSum = 0, ans = nums.length + 1;
        for (int left = 0, right = 0; right < nums.length ; right ++){
            curSum += nums[right];
            if (curSum < target){
                continue;
            }
            while (curSum - nums[left] >= target && left <= right){
                curSum -= nums[left];
                left ++;
            }
            ans = Math.min(ans, right - left  +1);
        }
        return ans > nums.length ? 0 : ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}