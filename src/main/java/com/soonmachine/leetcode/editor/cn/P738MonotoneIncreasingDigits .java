//当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。 
//
// 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 10
//输出: 9
// 
//
// 示例 2: 
//
// 
//输入: n = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 
//输入: n = 332
//输出: 299
// 
//
// 
//
// 提示: 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 贪心 数学 👍 446 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//java:单调递增的数字

/**
 * 单调递增的数字
 * 1. 贪心
 * 贪心策略：从后往前遍历，如果当前数字大于后一位数字，那么当前数字减一，然后后面的数字都变成9
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class P738MonotoneIncreasingDigits{
    public static void main(String[] args){
        Solution solution = new P738MonotoneIncreasingDigits().new Solution();
        solution.monotoneIncreasingDigits(332);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] charArray = String.valueOf(n).toCharArray();
        int start = charArray.length;
        for (int i = charArray.length - 2; i >= 0; i --){
            if (charArray[i] > charArray[i + 1]){
                charArray[i] --;
                start = i + 1;
            }
        }
        while (start < charArray.length){
            charArray[start ++] = '9';
        }
        return Integer.parseInt(String.valueOf(charArray));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}