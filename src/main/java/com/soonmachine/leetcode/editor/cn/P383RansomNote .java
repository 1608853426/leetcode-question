//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 825 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.*;

//java:赎金信

/**
 * 赎金信
 * 用一个数组统计 magazine 中每个字符出现的次数，然后遍历 ransomNote，
 * 对于 ransomNote 中的每个字符，如果在数组中的出现次数大于 0，则将其出现次数减 1，
 * 如果在数组中的出现次数等于 0，则返回 false。
 * 遍历结束后，返回 true。
 * 时间复杂度：O(m+n)，其中 m 和 n 分别是字符串 ransomNote 和 magazine 的长度。
 * 需要遍历字符串 magazine 一次，时间复杂度是 O(m)，使用的空间是 O(∣Σ∣)，其中 Σ 是字符集，
 */
class P383RansomNote{
    public static void main(String[] args){
        Solution solution = new P383RansomNote().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char c : magazine.toCharArray()){
            map[c - 'a'] ++;
        }
        for (char c : ransomNote.toCharArray()){
            if (--map[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}