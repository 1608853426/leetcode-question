//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1516 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//java:全排列 II
class P47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            ans.clear();
            path.clear();
            boolean[] used = new boolean[nums.length];
            dfs(nums, used);
            return ans;
        }

        void dfs(int[] nums, boolean[] used) {
            if (path.size() == nums.length) {
                ans.add(new ArrayList<>(path));
                return;
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])){
                    continue;
                }
                if (!used[i]) {
                    set.add(nums[i]);
                    path.add(nums[i]);
                    used[i] = true;
                    dfs(nums, used);
                    path.remove(path.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}