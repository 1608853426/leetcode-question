//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2411 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:数组中的第K个最大元素

import java.util.Arrays;
import java.util.Collections;

/**
 * 数组中的第K个最大元素
 * 1. 排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(logn)
 * 2. 堆
 * 时间复杂度：O(nlogk)
 * 空间复杂度：O(k)
 * 3. 快速选择
 * 首先将数组划分为两部分，左边的元素都大于等于基准元素，右边的元素都小于等于基准元素
 * 如果基准元素的下标等于k-1，返回基准元素
 * 如果基准元素的下标大于k-1，递归左边的元素
 * 如果基准元素的下标小于k-1，递归右边的元素
 * 时间复杂度：O(n)
 * 空间复杂度：O(logn)
 */
class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(solution.findKthLargest(nums, k));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, k);
        }

        int quickSelect(int[] nums, int l, int r, int k) {
            if (l == r) {
                return nums[l];
            }
            int x = nums[l];
            int i = l - 1;
            int j = r + 1;
            while (i < j) {
                do {
                    i++;
                } while (nums[i] > x);
                do {
                    j--;
                } while (nums[j] < x);
                if (i < j) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
                //print nums
                for (int num : nums) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            int sl = j - l + 1;
            if (k <= sl) {
                return quickSelect(nums, l, j, k);
            }
            return quickSelect(nums, j + 1, r, k - sl);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}