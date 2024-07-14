package com.soonmachine.leetcode.editor.cn;


import java.util.*;


import java.util.*;


public class Solution {
    public int[] solution(int[] costs, int coins) {
        ArrayList<Pair> list = new ArrayList<>();
        List<Pair> cList = new ArrayList<>();
        for (int i = 0; i < costs.length; i ++){
            cList.add(new Pair(costs[i], i));
        }
        cList.sort((a, b) -> a.first == b.first ? a.second - b.second : a.first - b.first);
        for (Pair cost : cList) {
            if (coins >= cost.first) {
                list.add(cost);
                coins -= cost.first;
            } else {
                break;
            }
        }
        list.sort(Comparator.comparingInt(a -> a.second));
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i ++){
            res[i] = list.get(i).first;
        }

        return res;
    }

    class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public String reverses(String original_str) {
        String[] word = original_str.split(" ");
        for (int i = 0; i < word.length; i++) {
            List<Character> lower = new ArrayList<>();
            for (char c : word[i].toCharArray()){
                if (Character.isLowerCase(c)){
                    lower.add(c);
                }
            }
            Collections.reverse(lower);
            StringBuilder result = new StringBuilder();
            int lowIndex = 0;
            for (char c : word[i].toCharArray()){
                if (Character.isLowerCase(c)){
                    result.append(lower.get(lowIndex++));
                }else {
                    result.append(c);
                }
            }
            word[i] = result.toString();
        }
        return String.join(" ", word);
    }



    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     * 旋转链表
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode Rotate(ListNode head, int k) {
        // write code here
        ListNode p = head;
        ListNode q = head;
        int cnt = 0;
        if (head == null || head.next == null || k == 0){
            return head;
        }
        while(p != null){
            p = p.next;
            cnt ++;
        }
        p = head;
        k %= cnt;
        if(k == 0){
            return head;
        }
        while(k -- > 0){
            q = q.next;
        }

        while(q.next != null){
            q = q.next;
            p = p.next;
        }
        ListNode res = p.next;
        p.next = null;
        q.next = head;
        return res;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型
     */
    static int[] tmp;

    public int cntOfSwap(TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        //先序遍历, 迭代方式
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        tmp = new int[list.size()];
        return getNum(arr, 0, arr.length - 1);
    }

    public int getNum(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + right >> 1;
        int ll = getNum(arr, left, mid);
        int rr = getNum(arr, mid + 1, right);
        int cc = mergeSort(arr, left, mid, right);
        return ll + rr + cc;
    }

    //计算逆序对的数量
    int mergeSort(int[] arr, int l, int mid, int r) {
        int i = l, j = mid + 1, k = 0;
        int res = 0;
        int[] u = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                u[k++] = arr[i++];
            } else {
                u[k++] = arr[j++];
                res += mid - i + 1;
            }
        }
        while (i <= mid) {
            u[k++] = arr[i++];
        }
        while (j <= r) {
            u[k++] = arr[j++];
        }
        for (int p = 0; p < k; p++) {
            arr[l + p] = u[p];
        }
        return res;
    }
}