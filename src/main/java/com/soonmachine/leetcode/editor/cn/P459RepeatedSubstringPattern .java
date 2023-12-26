//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 👍 1106 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:重复的子字符串

/**
 * 重复的子字符串
 * 1. 移动匹配
 * 如果 s 包含多个子串，那么 s+s 包含至少四个子串，两个子串被连接在一起，中间至少有两个原来的 s。
 * 所以，我们只需要判断 s+s 中去掉第一个和最后一个字符后，是否包含 s，如果包含则说明 s 存在重复的子串。
 *
 */
class P459RepeatedSubstringPattern{
    public static void main(String[] args){
        Solution solution = new P459RepeatedSubstringPattern().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        String substring = str.substring(1, str.length() - 1);
        return  substring.contains(s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}