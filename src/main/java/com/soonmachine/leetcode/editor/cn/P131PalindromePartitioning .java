//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1709 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

//java:分割回文串

/**
 * 分割回文串
 * 1. 递归
 * 1. 递归终止条件：startIndex == s.length()
 * 2. 递归过程：从startIndex开始遍历，如果是回文串，path.add(i)，递归，path.remove(path.size()-1)
 * 3. 递归返回值：无
 * 时间复杂度：O(n*2^n)
 * 空间复杂度：O(n)

 */
class P131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new P131PalindromePartitioning().new Solution();
        String s = "aab";
        solution.partition(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            List<String> path = new ArrayList<>();
            dfs(s, 0, ans, path);
            return ans;
        }

        void dfs(String s, int startIndex, List<List<String>> ans, List<String> path ){
            if (startIndex == s.length()){
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i < s.length(); i++) {
                if (isPalindrome(s,startIndex,i)){
                    path.add(s.substring(startIndex, i + 1));
                    dfs(s, i + 1, ans, path);
                    path.remove(path.size() - 1);
                }
            }
        }
        boolean isPalindrome(String s, int start, int end){
            while (start < end){
                if (s.charAt(start) != s.charAt(end)){
                    return false;
                }
                start ++;
                end --;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}