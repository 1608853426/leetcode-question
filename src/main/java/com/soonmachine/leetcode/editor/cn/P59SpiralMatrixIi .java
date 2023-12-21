//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1231 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:螺旋矩阵 II

/**
 * 1. 模拟
 * 2. 定义四个边界，left，right，top，bottom
 * 3. 从左到右，从上到下，从右到左，从下到上，依次遍历
 * 4. 每次遍历完，边界向内收缩
 * 5. 重复3，4步骤，直到left > right || top > bottom
 * 6. 返回数组
 * 时间复杂度：O(n^2)
 */
class P59SpiralMatrixIi{
    public static void main(String[] args){
        Solution solution = new P59SpiralMatrixIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int cur = 1;
        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i++) {
                ans[top][i] = cur ++;
            }
            top ++;

            for (int i = top; i <= bottom; i ++){
                ans[i][right] = cur ++;
            }
            right --;

            for (int i = right; i >= left; i --){
                ans[bottom][i] = cur ++;
            }
            bottom --;

            for (int i = bottom; i >= top; i --){
                ans[i][left] = cur ++;
            }
            left ++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}