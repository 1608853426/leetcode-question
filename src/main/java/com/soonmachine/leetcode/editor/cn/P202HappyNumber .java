//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」 定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果这个过程 结果为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 19
//输出：true
//解释：
//1² + 9² = 82
//8² + 2² = 68
//6² + 8² = 100
//1² + 0² + 0² = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 哈希表 数学 双指针 👍 1492 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:快乐数

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * 1. 用一个 HashSet 存储所有出现过的数字，然后每次进行平方和运算。
 * 2. 如果得到的新的数字在 HashSet 中，那么说明产生了循环，因此退出循环，并且返回 false。
 * 3. 如果得到的新的数字不在 HashSet 中，那么继续进行平方和运算。
 * 4. 最终如果平方和运算结果等于 1，那么说明是快乐数，返回 true；否则不是快乐数，返回 false。
 * 时间复杂度：O(logn)。
 * 空间复杂度：O(logn)。
 */
class P202HappyNumber{
    public static void main(String[] args){
        Solution solution = new P202HappyNumber().new Solution();
        int n = 19;
        System.out.println(solution.isHappy(n));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        Set<Long> set = new HashSet<>();
        while (n != 1){
            long sum = 0;
            while (n > 0){
                int tmp = n % 10;
                n /= 10;
                sum += tmp * tmp;
            }
            if (set.contains(sum)){
                return false;
            }
            set.add(sum);
            n = (int) sum;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}