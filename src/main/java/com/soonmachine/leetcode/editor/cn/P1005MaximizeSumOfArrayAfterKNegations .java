//给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组： 
//
// 
// 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。 
// 
//
// 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。 
//
// 以这种方式修改数组后，返回数组 可能的最大和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,2,3], k = 1
//输出：5
//解释：选择下标 1 ，nums 变为 [4,-2,3] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,-1,0,2], k = 3
//输出：6
//解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-3,-1,5,-4], k = 2
//输出：13
//解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -100 <= nums[i] <= 100 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 贪心 数组 排序 👍 434 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.Arrays;
import java.util.Comparator;

//java:K 次取反后最大化的数组和

/**
 * K 次取反后最大化的数组和
 * 1. 贪心
 * 贪心策略：先按照气球的左边界排序，然后从左到右遍历，如果当前气球的左边界大于上一支箭的射击位置，那么需要增加一支箭
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(logn)
 */
class P1005MaximizeSumOfArrayAfterKNegations{
    public static void main(String[] args){
        int[] arr = {-3, 4, -2, 1};
        Solution solution = new P1005MaximizeSumOfArrayAfterKNegations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int index = 0;
        while (k > nums.length){
            k -= 2;
        }
        while (k > 0){
            if (nums[index] >= 0){
                Arrays.sort(nums);
                if ((k & 1) == 1){
                    nums[0] *= -1;
                }
                break;
            }else {
                nums[index ++] *= -1;
                k --;
            }
        }
        return Arrays.stream(nums).sum();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}