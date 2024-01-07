//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1503 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:组合总和 II

/**
 * 组合总和 II
 * 1. 递归
 * 终止条件：sum > target, 或者sum == target, 此时将path加入ans
 * 递归过程：从start开始遍历，如果i>0 && candidates[i] == candidates[i-1]，说明当前数字和前一个数字相同，跳过
 * 递归返回值：无
 *
 */
class P40CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            boolean[] used = new boolean[candidates.length];
            Arrays.sort(candidates);
            dfs(candidates, target, 0, path, ans, used, 0);
            return ans;
        }

        void dfs(int[] candidates, int target, int sum, List<Integer> path, List<List<Integer>> ans, boolean[] used, int startIndex) {
            if (sum > target) {
                return;
            }
            if (sum == target) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i < candidates.length; i++) {
                if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]){
                    continue;
                }
                path.add(candidates[i]);
                used[i] = true;
                dfs(candidates, target, sum + candidates[i], path, ans ,used,i + 1);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}