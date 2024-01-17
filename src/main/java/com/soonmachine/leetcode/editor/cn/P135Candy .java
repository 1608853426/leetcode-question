//n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。 
//
// 你需要按照以下要求，给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻两个孩子评分更高的孩子会获得更多的糖果。 
// 
//
// 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：ratings = [1,0,2]
//输出：5
//解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：ratings = [1,2,2]
//输出：4
//解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。 
//
// 
//
// 提示： 
//
// 
// n == ratings.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= ratings[i] <= 2 * 10⁴ 
// 
//
// Related Topics 贪心 数组 👍 1432 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.Arrays;

//java:分发糖果

/**
 * 分发糖果
 * 1. 贪心
 * 贪心策略：先给每个孩子1颗糖，然后从左到右遍历，如果右边孩子评分比左边高，那么右边孩子的糖果数为左边孩子的糖果数+1
 * 再从右到左遍历，如果左边孩子评分比右边高，那么左边孩子的糖果数为右边孩子的糖果数+1
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class P135Candy{
    public static void main(String[] args){
        Solution solution = new P135Candy().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies,1);
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]){
                candies[i + 1] = candies[i] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]){
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
        }
        return Arrays.stream(candies).sum();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}