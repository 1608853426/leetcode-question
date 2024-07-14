//给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//输出：3
//解释：长度最长的公共子数组是 [3,2,1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 100 
// 
//
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 1050 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:最长重复子数组
class P718MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new P718MaximumLengthOfRepeatedSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int[][] dp = new int[m][n];
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (nums1[i] == nums2[j]) {
                        dp[i][j] = 1;
                        if (i > 0 && j > 0) {
                            dp[i][j] += dp[i - 1][j - 1];
                        }
                        res = Math.max(res, dp[i][j]);
                    }

                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}