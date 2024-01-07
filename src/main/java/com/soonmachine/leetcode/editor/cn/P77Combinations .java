//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1567 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

//java:

/**
 * 组合
 * 解法一：递归
 * 1. 递归终止条件：path.size()==k
 * 2. 递归过程：从startIndex开始遍历，path.add(i)，递归，path.remove(path.size()-1)
 * 3. 递归返回值：无
 * 时间复杂度：O(n^k)
 * 空间复杂度：O(k)
 */
class P77Combinations {
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            if (n < k){
                return  ans;
            }
            List<Integer> path = new ArrayList<>();
            dfs(ans, path, 1, n, k);
            return ans;
        }

        void dfs(List<List<Integer>> ans, List<Integer> path, int startIndex, int n, int k){
            int endIndex = n - (k - path.size()) + 1;
            for (int i = startIndex; i <= endIndex; i++) {
                path.add(i);
                if (path.size() == k){
                    ans.add(new ArrayList<>(path));
                    path.remove(path.size() - 1);
                    continue;
                }
                dfs(ans, path, i + 1, n, k);
                path.remove(path.size() - 1);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}