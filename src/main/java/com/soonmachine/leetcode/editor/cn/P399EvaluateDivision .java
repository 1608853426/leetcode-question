//给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 
//values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。 
//
// 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj =
// ? 的结果作为答案。 
//
// 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替
//代这个答案。 
//
// 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。 
//
// 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"]
//,["b","a"],["a","e"],["a","a"],["x","x"]]
//输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
//解释：
//条件：a / b = 2.0, b / c = 3.0
//问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
//注意：x 是未定义的 => -1.0 
//
// 示例 2： 
//
// 
//输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], 
//queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//输出：[3.75000,0.40000,5.00000,0.20000]
// 
//
// 示例 3： 
//
// 
//输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],[
//"a","c"],["x","y"]]
//输出：[0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj 由小写英文字母与数字组成 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 数组 最短路 👍 1047 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

//java:除法求值

/**
 * 1. 并查集
 * 并查集的思想是，将所有变量看成一个个节点，将等式看成连接两个节点的边，那么对于每个查询，就是在看两个节点是否连通，如果连通，就可以求出结果。
 * 2. DFS
 * 从起点开始，遍历图，直到找到终点为止，如果找不到终点，就返回-1.0
 */
class P399EvaluateDivision{
    public static void main(String[] args){
        Solution solution = new P399EvaluateDivision().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 并查集
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<>();
        int n = equations.size();
        for (List<String> equation : equations) {
            if (!variables.containsKey(equation.get(0))) {
                variables.put(equation.get(0), nvars++);
            }
            if (!variables.containsKey(equation.get(1))) {
                variables.put(equation.get(1), nvars++);
            }
        }
        int[] f = new int[nvars];
        double[] w = new double[nvars];
        for (int i = 0; i < nvars; i++) {
            f[i] = i;
            w[i] = 1.0;
        }
        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0));
            int vb = variables.get(equations.get(i).get(1));
            merge(f, w, va, vb, values[i]);
        }
        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            Integer ia = variables.get(queries.get(i).get(0));
            Integer ib = variables.get(queries.get(i).get(1));
            if (ia == null || ib == null) {
                ret[i] = -1.0;
            } else {
                ret[i] = ia.equals(ib) ? 1.0 : calc(f, w, ia, ib);
            }
        }
        return ret;
    }

    public void merge(int[] f, double[] w, int x, int y, double val) {
        int fx = find(f, w, x);
        int fy = find(f, w, y);
        f[fx] = fy;
        w[fx] = val * w[y] / w[x];
    }

    public int find(int[] f, double[] w, int x) {
        if (f[x] != x) {
            int father = find(f, w, f[x]);
            w[x] *= w[f[x]];
            f[x] = father;
        }
        return f[x];
    }

    public double calc(int[] f, double[] w, int x, int y) {
        int fx = find(f, w, x);
        int fy = find(f, w, y);
        if (fx != fy) {
            return -1.0;
        }
        return w[x] / w[y];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}