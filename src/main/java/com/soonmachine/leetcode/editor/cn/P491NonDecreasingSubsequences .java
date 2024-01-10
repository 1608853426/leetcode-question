//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 位运算 数组 哈希表 回溯 👍 758 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//java:非递减子序列

/**
 * 非递减子序列
 * 1. 递归
 * 1. 递归终止条件：startIndex == nums.length
 * 2. 递归过程：用一个set记录当前层处理过的元素 从startIndex开始遍历，如果当前数字已经处理过，跳过，否则加入set
 * 3. 如果path为空，或者当前数字大于等于path中最后一个数字，将当前数字加入path，递归startIndex+1
 * 4. 递归返回值：无
 */
class P491NonDecreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new P491NonDecreasingSubsequences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            dfs(nums, 0);
            return ans;
        }

        void dfs(int[] nums, int startIndex){
            if (path.size() > 1){
                ans.add(new ArrayList<>(path));
            }
            Set<Integer> set = new HashSet<>();
            for (int i = startIndex; i < nums.length; i ++){
                if (set.contains(nums[i])){
                    continue;
                }
                set.add(nums[i]);
                if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)){
                    path.add(nums[i]);
                    dfs(nums, i + 1);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}