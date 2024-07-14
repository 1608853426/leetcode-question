//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5012 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:接雨水
class P42TrappingRainWater{
    public static void main(String[] args){
        Solution solution = new P42TrappingRainWater().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        if (height.length <= 2){
            return 0;
        }
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i -1]);
        }

        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i --){
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        int res = 0;
        for (int i = 1; i < height.length - 1; i ++){
            int tmp = Math.min(maxLeft[i - 1], maxRight[i + 1]) - height[i];
            res += Math.max(tmp, 0);
        }
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}