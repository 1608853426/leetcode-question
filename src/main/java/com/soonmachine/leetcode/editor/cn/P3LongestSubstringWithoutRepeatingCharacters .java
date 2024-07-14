//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 9986 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//java:无重复字符的最长子串
class P3LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args){
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()){
            if (set.contains(c)){
                while ( !queue.isEmpty() ){
                    char first = queue.poll();
                    set.remove(first);
                    if (first == c){
                        break;
                    }
                }
            }
            queue.offer(c);
            set.add(c);
            res = Math.max(res, queue.size());
        }
        return res;
     }
}
//leetcode submit region end(Prohibit modification and deletion)

}