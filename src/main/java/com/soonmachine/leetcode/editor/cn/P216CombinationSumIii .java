//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件： 
//
// 
// 只使用数字1到9 
// 每个数字 最多使用一次 
// 
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。 
//
// 
//
// 示例 1: 
//
// 
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。 
//
// 示例 2: 
//
// 
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//没有其他符合的组合了。 
//
// 示例 3: 
//
// 
//输入: k = 4, n = 1
//输出: []
//解释: 不存在有效的组合。
//在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
// 
//
// 
//
// 提示: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
//
// Related Topics 数组 回溯 👍 796 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

//java:组合总和 III

/**
 * 组合总和 III
 * 1. 递归
 * 1. 递归终止条件：k==0 && n==0
 * 2. 递归过程：从start开始遍历，如果i>n，说明当前数字已经大于n，直接返回
 * 3. 递归返回值：如果k==0 && n==0，说明找到了一组解，ans.add(new ArrayList<>(path))
 * 时间复杂度：O(9!)
 * 空间复杂度：O(k)

 */
class P216CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new P216CombinationSumIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(k, n, 1, path, ans);
            return ans;
        }

        void dfs(int k, int target, int startIndex, List<Integer> path, List<List<Integer>> ans){
            if (startIndex > target){
                return;
            }
            int endIndex = 9 - (k - path.size()) + 1;
            for (int i = startIndex; i <= endIndex; i++) {
                if (i > target){
                    return;
                }
                if (target == i && path.size() == k - 1){
                    path.add(i);
                    ans.add(new ArrayList<>(path));
                    path.remove(path.size() - 1);
                    return;
                }
                path.add(i);
                dfs(k, target - i, i + 1, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}