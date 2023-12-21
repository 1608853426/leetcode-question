//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
//
// Related Topics 数组 二分查找 👍 1505 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:二分查找

/**
 * 二分查找
 * 1. 从中间行开始，找到最大值
 * 2. 如果最大值比左右两边都大，那么就是峰值
 * 3. 如果最大值比左边大，比右边小，那么峰值在左边
 * 4. 如果最大值比左边小，比右边大，那么峰值在右边
 * 5. 重复1-4，直到找到峰值
 */
class P704BinarySearch{
    public static void main(String[] args){

        Solution solution = new P704BinarySearch().new Solution();
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(solution.search(nums, 9));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + right >> 1;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}