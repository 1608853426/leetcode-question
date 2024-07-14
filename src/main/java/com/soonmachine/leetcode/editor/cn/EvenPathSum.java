package com.soonmachine.leetcode.editor.cn;
import java.util.*;
public class EvenPathSum {
    static long evenPathCount = 0; // 存储权值和为偶数的路径数量
    static List<List<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt();
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        dfs(0, -1, 0);

        System.out.println(evenPathCount);
    }

    static void dfs(int node, int parent, int pathSum) {
        pathSum %= 2; // 仅关心奇偶性，不需要实际的和
        if (pathSum == 0) {
            evenPathCount++;
        }

        for (Edge edge : graph.get(node)) {
            if (edge.to != parent) {
                dfs(edge.to, node, pathSum + edge.weight);
            }
        }
    }

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
