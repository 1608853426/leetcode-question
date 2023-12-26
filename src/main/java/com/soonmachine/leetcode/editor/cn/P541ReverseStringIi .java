//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 565 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.Arrays;

//java:反转字符串 II
/**
 * 反转字符串 II
 * 1. 从头开始，每 2k 个字符一组进行反转。
 * 2. 对于每个小组，先判断它是否够 k 个字符，如果不够就直接反转，如果够 k 个字符，就反转前 k 个字符。
 * 3. 由于反转的字符从 0 开始计数，因此判断条件是 i < len。
 * 4. 最后将每个小组拼接起来即可。
 */
class P541ReverseStringIi{
    public static void main(String[] args){
        Solution solution = new P541ReverseStringIi().new Solution();
        String s = "abcd";
        int k = 3;
        System.out.println(solution.reverseStr(s, k));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        int time = s.length() / (2 * k);
        int last = s.length() % (2 * k);
        int tmp = 0;
        char[] chars = s.toCharArray();
        while (time > 0){
            int left = tmp;
            int right = left + k - 1;
            while (left < right){
                char c = chars[left];
                chars[left] = chars[right];
                chars[right] = c;
                left ++;
                right --;
            }
            time --;
            tmp += 2 * k;
        }
        int left = tmp;
        int right;
        if (last < k) {
            right = s.length() -1;
        }else {
            right = tmp + k - 1;
        }
        while (left < right){
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
            left ++;
            right --;
        }
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}