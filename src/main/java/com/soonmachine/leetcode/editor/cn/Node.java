package com.soonmachine.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * N 叉数的定义
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
