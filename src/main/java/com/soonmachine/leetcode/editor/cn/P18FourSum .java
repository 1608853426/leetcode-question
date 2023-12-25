//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1830 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:四数之和

/**
 * 四数之和
 * 1. 首先对数组进行排序，排序后固定两个数 nums[i] 和 nums[j]，
 * 2. 双指针分别指向 nums[i] 后面的开始位置和末尾位置，
 * 3. 根据 sum 与 target 的大小关系来移动两个指针。
 * 4. 当 sum<target 时，左指针右移使 sum 变大，当 sum>target 时，右指针左移使 sum 变小。
 * 5. 注意，如果 nums[i] 和 nums[j] 的值与之前的相等，就跳过这次循环，因为已经计算过了。
 * 时间复杂度：O(n^3)
 */
class P18FourSum {
    public static void main(String[] args) {
        Solution solution = new P18FourSum().new Solution();
        //[1000000000,1000000000,1000000000,1000000000]
        //			-294967296
        int[] nums = new int[]{1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> ans = solution.fourSum(nums, target);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                //去重
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    //去重
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int left = j + 1;
                    int right = nums.length - 1;
                    //注意这里的类型转换，因为target是int类型，nums[i]和nums[j]是int类型，所以这里要转换成long类型
                    long tmp = (long) target - nums[i] - nums[j];
                    while (left < right) {
                        if (nums[left] + nums[right] == tmp) {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            //去重
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            left++;
                            right--;
                        } else if (nums[left] + nums[right] < tmp) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}