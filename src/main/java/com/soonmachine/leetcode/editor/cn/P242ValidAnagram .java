//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// Related Topics 哈希表 字符串 排序 👍 878 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:有效的字母异位词

/**
 * 有效的字母异位词
 * 哈希表
 * 1. 两个字符串长度不相等，直接返回false
 * 2. 两个字符串长度相等，遍历字符串s，用哈希表记录每个字符出现的次数
 * 3. 遍历字符串t，用哈希表记录每个字符出现的次数
 * 4. 遍历哈希表，如果哈希表中的每个字符出现的次数都相等，返回true，否则返回false
 * 时间复杂度：O(n)，其中 n 为 s 的长度。
 * 空间复杂度：O(S)，其中 S 为字符集大小，此处 S=26。
 */
class P242ValidAnagram{
    public static void main(String[] args){
        Solution solution = new P242ValidAnagram().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] map = new int[26];
        for (char c : s.toCharArray()){
            map[c - 'a'] ++;
        }
        for (char c : t.toCharArray()){
            map[c - 'a'] --;
            if (map[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}