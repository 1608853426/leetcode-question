package com.soonmachine.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class TecentTest {

    static int[] parent;
    static int[] size;
    static int[] rank;


    public static void main(String[] args) {
        int[][] values = {{1, 3}, {2, 4}, {1, 5}, {4, 1},{4, 2}};
        //如果是偶数个，全部点亮
        int res = 0;

        if (values.length % 2 == 0){

        }else {

        }


    }


    static int find(int x){
        if (parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void combine(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY){
            if (rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }else if (rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }else{
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                rank[rootX] ++;
            }
        }
    }



    static void dfs(int[] arr, int size,  List<Integer> path, List<List<Integer>> res){
        if (size == arr.length){
            res.add(new ArrayList<>(path));
            return;
        }
        //不选当前
        dfs(arr, size + 1, path, res);

        //选当前
        path.add(arr[size]);
        dfs(arr, size + 1, path, res);
    }
}


