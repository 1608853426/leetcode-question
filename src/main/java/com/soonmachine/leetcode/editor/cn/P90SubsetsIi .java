//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
//
// Related Topics 位运算 数组 回溯 👍 1181 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:子集 II

/**
 * 子集 II
 * 这道题和P78Subsets的区别在于，数组中可能包含重复元素，所以需要去重
 * 去重的方法是：先排序，然后在递归的时候，如果当前数字和前一个数字相同，不选的情况下，跳过
 * 1. 递归
 * 1. 递归终止条件：depth==nums.length
 * 2. 递归过程：不选，选
 * 3. 不选的情况下，path不变，depth+1, 递归depth+1
 * 4. 选的情况下，path.add(nums[depth]), depth+1, 递归depth+1, 递归完成后，path.remove(path.size()-1)
 * 5. 递归返回值：无
 */
class P90SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new P90SubsetsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        boolean[] used;

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            used = new boolean[nums.length];
            dfs(0, nums);
            return ans;
        }
        //used表示前一个数字是否被选中
        //soonmachine精简写法
        /*void dfs(int depth, int[] nums, boolean used) {
            if (depth == nums.length) {
                ans.add(new ArrayList<>(path));
                return;
            }
            //不选
            if (depth == 0 || nums[depth] != nums[depth - 1] || !used) {
                dfs(depth + 1, nums, false);
            }

            //选
            path.add(nums[depth]);
            dfs(depth + 1, nums, true);
            path.remove(path.size() - 1);
        }*/

        void dfs(int startIndex, int[] nums){
            //这是当前数字不选的情况
            ans.add(new ArrayList<>(path));
            //递归终止条件
            if (startIndex == nums.length){
                return;
            }
            //递归过程
            for (int i = startIndex; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                dfs(i + 1, nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}