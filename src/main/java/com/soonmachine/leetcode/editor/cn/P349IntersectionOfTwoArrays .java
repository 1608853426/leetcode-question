//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 866 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:两个数组的交集

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  两个数组的交集
 *  1. 遍历nums1，将nums1中的元素放入set1中
 *  2. 遍历nums2, 如果set1中包含nums2中的元素，就将元素放入结果中
 */
class P349IntersectionOfTwoArrays{
    public static void main(String[] args){
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for (int x : nums1){
            set1.add(x);
        }
        for (int x : nums2){
            if (set1.contains(x)){
                ans.add(x);
                set1.remove(x);
            }
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}