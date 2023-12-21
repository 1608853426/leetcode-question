//给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。 
//
// 不能使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
//解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
//解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 556 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:有效的完全平方数

/**
 * 二分查找
 * 1. 从1到num/2，找到中间值mid
 * 2. 如果mid的平方等于num，返回true
 * 3. 如果mid的平方小于num，那么在mid的右边继续查找
 * 4. 如果mid的平方大于num，那么在mid的左边继续查找
 * 5. 重复1-4，直到找到mid的平方等于num，或者left>right
 * 6. 返回false
 * 7. 查找完成
 * 注意：这里要用long类型，否则会溢出
 */
class P367ValidPerfectSquare{
    public static void main(String[] args){
        int num = 808201;
        Solution solution = new P367ValidPerfectSquare().new Solution();
        System.out.println(solution.isPerfectSquare(num));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int left = 1, right = num/2;
        while (left <= right){
            int mid = left + right >> 1;
            if ((long)mid * mid < num){
                left  = mid + 1;
            } else if ((long)mid * mid > num) {
                right = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}