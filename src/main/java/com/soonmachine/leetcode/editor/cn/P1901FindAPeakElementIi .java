//一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。 
//
// 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返回其位置
// [i,j] 。 
//
// 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。 
//
// 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法 
//
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: mat = [[1,4],[3,2]]
//输出: [0,1]
//解释: 3 和 4 都是峰值，所以[1,0]和[0,1]都是可接受的答案。
// 
//
// 示例 2: 
//
// 
//
// 
//输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
//输出: [1,1]
//解释: 30 和 32 都是峰值，所以[1,1]和[2,2]都是可接受的答案。
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 500 
// 1 <= mat[i][j] <= 10⁵ 
// 任意两个相邻元素均不相等. 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 125 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:寻找峰值 II

/**
 * 二分查找
 * 1. 从中间行开始，找到最大值
 * 2. 如果最大值比左右两边都大，那么就是峰值
 * 3. 如果最大值比左边大，比右边小，那么峰值在左边
 * 4. 如果最大值比左边小，比右边大，那么峰值在右边
 * 5. 重复1-4，直到找到峰值
 */
class P1901FindAPeakElementIi {
    public static void main(String[] args) {
        Solution solution = new P1901FindAPeakElementIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findPeakGrid(int[][] mat) {
            // 二分查找
            int left = 0;
            int right = mat.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int col = findMaxCol(mat, mid);
                if (mid - 1 >= 0 && mat[mid - 1][col] > mat[mid][col]) {
                    right = mid - 1;
                } else if (mid + 1 < mat.length && mat[mid + 1][col] > mat[mid][col]) {
                    left = mid + 1;
                } else {
                    return new int[]{mid, col};
                }
            }
            return new int[]{-1, -1};
        }

        private int findMaxCol(int[][] mat, int row) {
            int max = 0;
            int col = 0;
            for (int i = 0; i < mat[row].length; i++) {
                if (mat[row][i] > max) {
                    max = mat[row][i];
                    col = i;
                }
            }
            return col;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}