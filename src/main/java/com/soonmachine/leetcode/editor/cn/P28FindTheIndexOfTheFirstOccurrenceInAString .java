//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 2109 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:找出字符串中第一个匹配项的下标

/**
 * 找出字符串中第一个匹配项的下标
 * kmp算法
 * 1. 先去掉首尾空格
 * 2. 从头开始遍历，如果当前字符和needle的第一个字符相等，那么就开始匹配，如果不相等，那么就从haystack的下一个字符开始匹配
 * 3. 如果匹配成功，那么就返回当前的下标，如果匹配失败，那么就从haystack的下一个字符开始匹配
 * 4. 如果遍历完haystack都没有匹配成功，那么就返回-1
 * 时间复杂度：O(m+n)，其中 m 和 n 分别是字符串 haystack 和 needle 的长度。
 * 空间复杂度：O(n)，其中 n 是字符串 needle 的长度。需要创建一个 next 数组存储 needle 的前缀函数。
 *
 * kmp算法的流程
 * 1. 先计算出needle的前缀函数，前缀函数的值表示当前位置之前的字符串中有多大长度的相同前缀后缀
 *
 */
class P28FindTheIndexOfTheFirstOccurrenceInAString{
    public static void main(String[] args){
        Solution solution = new P28FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        //1. 先去掉首尾空格
        haystack = haystack.trim();

        //2. 构造前缀函数
        int[] next = new int[needle.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < needle.length() - 1) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                i ++;
                j ++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        //3. 从头开始遍历，如果当前字符和needle的第一个字符相等，那么就开始匹配，如果不相等，那么就从haystack的下一个字符开始匹配
        i = 0;
        j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i ++;
                j ++;
            } else {
                j = next[j];
            }
        }

        //4. 如果匹配成功，那么就返回当前的下标，如果匹配失败，那么就从haystack的下一个字符开始匹配
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}