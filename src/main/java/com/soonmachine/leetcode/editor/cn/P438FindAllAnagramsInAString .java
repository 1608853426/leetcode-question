//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1386 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:找到字符串中所有字母异位词
class P438FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new P438FindAllAnagramsInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            int[] cmp = new int[26];
            if (p.length() > s.length()){
                return res;
            }
            for (char c : p.toCharArray()){
                cmp[c - 'a'] ++;
            }
            int n = p.length();
            for (int i = 0; i < n; i++) {
                cmp[s.charAt(i) - 'a'] --;
            }
            for (int i = n; i <= s.length(); i++) {
                boolean flag = true;
                for (int x : cmp){
                    if (x != 0){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    res.add(i - n);
                }
                if (i == s.length()){
                    break;
                }
                cmp[s.charAt(i - n) - 'a'] ++;
                cmp[s.charAt(i) - 'a'] --;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}