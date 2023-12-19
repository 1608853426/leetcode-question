//两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 1, y = 4
//输出：2
//解释：
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//上面的箭头指出了对应二进制位不同的位置。
// 
//
// 示例 2： 
//
// 
//输入：x = 3, y = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x, y <= 2³¹ - 1 
// 
//
// Related Topics 位运算 👍 722 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:汉明距离

/**
 * 汉明距离
 * ^ 异或运算
 * x ^ y = z
 * z的二进制表示中1的个数就是x和y的汉明距离
 * 1. z & 1 == 1，z的二进制表示的最后一位是1，res++
 * 2. z >>= 1，z右移一位
 * 3. 重复1，2步骤，直到z == 0
 */
class P461HammingDistance{
    public static void main(String[] args){
        Solution solution = new P461HammingDistance().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int res = 0;
        while (z != 0) {
            if ((z & 1) == 1) {
                res++;
            }
            z >>= 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}