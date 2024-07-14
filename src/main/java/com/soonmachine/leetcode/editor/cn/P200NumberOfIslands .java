//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2422 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.List;
import java.util.Stack;

//java:岛屿数量
class P200NumberOfIslands {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1'){
                        res ++;
                        dfs(grid, i , j);
                    }
                }
            }
            return res;
        }

        private void dfs(char[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1'){
                return;
            }
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i , j + 1);
            dfs(grid, i, j - 1);
        }

        public void bfs(char[][] grid, int i, int j){
            if (grid[i][j] != '1'){
                return;
            }
            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{i, j});
            while (!stack.isEmpty()){
                int[] node = stack.pop();
                int first = node[0];
                int second = node[1];
                if (first < 0 || second < 0 || first >= grid.length || second == grid.length || grid[first][second] != '1'){
                    continue;
                }
                grid[first][second] = '0';
                stack.push(new int[]{first + 1, second});
                stack.push(new int[]{first - 1, second});
                stack.push(new int[]{first, second + 1});
                stack.push(new int[]{first, second - 1});
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}