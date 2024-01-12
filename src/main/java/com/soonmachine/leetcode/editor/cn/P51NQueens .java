//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 2005 👎 0

package com.soonmachine.leetcode.editor.cn;


import javafx.scene.AmbientLight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:N 皇后

/**
 * n皇后问题
 * 回溯
 * 1. 回溯终止条件：depth == n
 * 2. 回溯过程：从第一行开始，遍历每一列，如果当前位置可以放置皇后，将皇后放置在当前位置，depth+1，递归depth+1，递归完成后，将皇后移除
 * 3. 回溯返回值：无
 * 时间复杂度：O(n!)
 * 空间复杂度：O(n)
 *
 * 判断当前位置是否可以放置皇后的方法：
 * 1. 检查当前行是否有皇后
 * 2. 检查当前列是否有皇后
 * 3. 检查当前位置的45度是否有皇后，只需要检查当前行之前的行
 * 4. 检查当前位置的135度是否有皇后，只需要检查当前行之前的行
 */
class P51NQueens {
    public static void main(String[] args) {
        Solution solution = new P51NQueens().new Solution();
        solution.solveNQueens(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[][] queens;
        int length;
        List<List<String>> ans = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            length = n;
            queens = new char[length][length];
            for (int i = 0; i < length; i++) {
                Arrays.fill(queens[i], '.');
            }
            ans.clear();
            dfs(0);
            return ans;
        }

        void dfs(int depth){
            if (depth == length){
                List<String> path = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    //Character[] to String
                    path.add(String.valueOf(queens[i]));
                }
                ans.add(path);
                return;
            }
            for (int i = 0; i < length; i++) {
                if (isValid(depth, i)){
                    queens[depth][i] = 'Q';
                    dfs(depth + 1);
                    queens[depth][i] = '.';
                }
            }
        }

        boolean isValid(int row, int column){
            for (int i = 0; i < length; i++) {
                    if (queens[row][i] == 'Q' || queens[i][column] == 'Q'){
                        return false;
                    }
            }
            //因为是按行放置的，所以只需要检查当前行之前的行
            //检查45度有没有冲突,下面的不用检查
            for (int i = row, j = column; i >= 0 && j>= 0; i --, j --){
                if (queens[i][j] == 'Q'){
                    return false;
                }
            }

            //检查135度有没有冲突，下面的不用检查
            for (int i = row, j = column; i >= 0 && j < length; i --, j ++){
                if (queens[i][j] == 'Q'){
                    return false;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}