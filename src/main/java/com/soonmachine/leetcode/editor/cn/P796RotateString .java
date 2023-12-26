//给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。 
//
// s 的 旋转操作 就是将 s 最左边的字符移动到最右边。 
//
// 
// 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", goal = "cdeab"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abcde", goal = "abced"
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, goal.length <= 100 
// s 和 goal 由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 👍 307 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:旋转字符串
//旋转字符串
//给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。

/**
 * 旋转字符串
 * 1. 从后往前遍历字符串 s，找到所有与 goal 的第一个字符相同的位置，记为 index；
 * 2. 比较 s[index:] + s[:index] 与 goal 是否相等，如果相等，则返回 true，否则返回 false。
 * 时间复杂度：O(n)，其中 n 是字符串 s 的长度。
 * 空间复杂度：O(1)。
 */
class P796RotateString{
    public static void main(String[] args){
        Solution solution = new P796RotateString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int n = s.length();
        int index = -1;
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == goal.charAt(0)) {
                index = i;
                if ((s.substring(index) + s.substring(0, index)).equals(goal)){
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}