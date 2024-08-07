//在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，所有其他节点都是该根节点的后继。该树除了根节点之外的每一个节点都有且只有一个父节点，而根节
//点没有父节点。 
//
// 输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。附加的边包含在 1 到 n 中的两个不同顶点间，这条
//附加的边不属于树中已存在的边。 
//
// 结果图是一个以边组成的二维数组 edges 。 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 
//vi 的一个父节点。 
//
// 返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。 
//
// 
//
// 示例 1： 
// 
// 
//输入：edges = [[1,2],[1,3],[2,3]]
//输出：[2,3]
// 
//
// 示例 2： 
// 
// 
//输入：edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
//输出：[4,1]
// 
//
// 
//
// 提示： 
//
// 
// n == edges.length 
// 3 <= n <= 1000 
// edges[i].length == 2 
// 1 <= ui, vi <= n 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 401 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:冗余连接 II
class P685RedundantConnectionIi {
    public static void main(String[] args) {
        Solution solution = new P685RedundantConnectionIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] father;

        public int[] findRedundantDirectedConnection(int[][] edges) {
            father = new int[edges.length + 1];
            int[] parent = new int[edges.length + 1];
            int[] candidate1 = null, candidate2 = null, conflict = null;
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                int u = edge[0], v = edge[1];
                if (parent[v] > 0) {
                    candidate1 = new int[]{parent[v], v};
                    candidate2 = new int[]{u, v};
                    edges[i][0] = edges[i][1] = -1;
                } else {
                    parent[v] = u;
                }
            }
            for (int i = 1; i <= edges.length; i++) {
                father[i] = i;
            }
            for (int[] edge : edges) {
                if (edge[0] == -1 || edge[1] == -1) {
                    continue;
                }
                int u = edge[0], v = edge[1];
                if (find(u) == find(v)) {
                    conflict = new int[]{u, v};
                } else {
                    father[find(u)] = find(v);
                }
            }
            if (candidate1 == null) {
                return conflict;
            }
            if (conflict != null) {
                return candidate1;
            }
            return candidate2;
        }

        int find(int x) {
            if (father[x] != x) {
                father[x] = find(father[x]);
            }
            return father[x];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}