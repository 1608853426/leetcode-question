//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2222 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

//java:子集

/**
 * 子集
 * 1. 递归
 * 1. 递归终止条件：depth==nums.length
 * 2. 递归过程：不选，选
 * 3. 不选的情况下，path不变，depth+1, 递归depth+1
 * 4. 选的情况下，path.add(nums[depth]), depth+1, 递归depth+1, 递归完成后，path.remove(path.size()-1)
 * 5. 递归返回值：无
 */
class P78Subsets {
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            dfs(ans, path, 0, nums);
            return ans;
        }

        void dfs(List<List<Integer>> ans, List<Integer> path, int depth, int[] nums) {
            if (depth == nums.length) {
                ans.add(new ArrayList<>(path));
                return;
            }
            //不选
            dfs(ans, path, depth + 1, nums);

            //选
            path.add(nums[depth]);
            dfs(ans, path, depth + 1, nums);
            path.remove(path.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}