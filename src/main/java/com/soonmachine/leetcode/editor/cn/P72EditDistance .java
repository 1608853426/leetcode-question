//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作：
//
//
// 插入一个字符
// 删除一个字符
// 替换一个字符
//
//
//
//
// 示例 1：
//
//
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//
//
// 示例 2：
//
//
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//
//
//
//
// 提示：
//
//
// 0 <= word1.length, word2.length <= 500
// word1 和 word2 由小写英文字母组成
//
//
// Related Topics 字符串 动态规划 👍 3229 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:编辑距离

/**
 * 1. 确定dp数组以及下标的含义
 * dp[i][j] 表示word1的前i个字符转换成word2的前j个字符所使用的最少操作数
 * 2. 确定递推公式
 * 如果word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]
 * 如果word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]) + 1
 * 3. dp数组如何初始化
 * dp[0][j] = j
 * dp[i][0] = i
 * 4. 确定遍历顺序
 * 从前往后遍历
 * 5. 举例推导dp数组
 * word1 = "horse", word2 = "ros"
 * dp[0][0] = 0
 * dp[0][1] = 1
 * dp[0][2] = 2
 * dp[0][3] = 3
 * dp[0][4] = 4
 * dp[1][0] = 1
 * dp[2][0] = 2
 * dp[3][0] = 3
 * dp[4][0] = 4
 * dp[5][0] = 5
 * dp[6][0] = 6
 * dp[7][0] = 7
 * dp[1][1] = 0
 * dp[1][2] = 1
 * dp[1][3] = 2
 * dp[1][4] = 3
 * dp[2][1] = 1
 * dp[2][2] = 1
 * dp[2][3] = 2
 * dp[2][4] = 3
 * dp[3][1] = 2
 * dp[3][2] = 2
 * dp[3][3] = 2
 * dp[3][4] = 3
 * dp[4][1] = 3
 * dp[4][2] = 3
 * dp[4][3] = 3
 */
class P72EditDistance {
    public static void main(String[] args) {
        Solution solution = new P72EditDistance().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            //初始化
            for (int i = 0; i < word1.length() + 1; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j < word2.length() + 1; j++) {
                dp[0][j] = j;
            }
            //遍历
            for (int i = 1; i < word1.length() + 1; i++) {
                for (int j = 1; j < word2.length() + 1; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}