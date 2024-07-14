//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1084 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:被围绕的区域
class P130SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new P130SurroundedRegions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private  int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 四个方向

        public void solve(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == 'O') {
                    dfs(board, i, 0, 'c');
                }
                if (board[i][board[0].length - 1] == 'O') {
                    dfs(board, i, board[0].length - 1, 'c');
                }
            }
            for (int i = 0; i < board[0].length; i++) {
                if (board[0][i] == 'O') {
                    dfs(board, 0, i, 'c');
                }
                if (board[board.length - 1][i] == 'O') {
                    dfs(board, board.length - 1, i, 'c');
                }
            }

            for (int i = 1; i < board.length - 1; i++) {
                for (int j = 1; j < board[0].length - 1; j++) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j, 'X');
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 'c') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        void dfs(char[][] board, int i, int j, char c) {
            if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == 'X') {
                return;
            }
            board[i][j] = c;
            dfs(board, i + 1, j, c);
            dfs(board, i - 1, j, c);
            dfs(board, i, j + 1, c);
            dfs(board, i, j - 1, c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}