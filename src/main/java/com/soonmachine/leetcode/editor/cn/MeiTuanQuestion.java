package com.soonmachine.leetcode.editor.cn;

import java.util.*;

public class MeiTuanQuestion {
    public static void main(String[] args) {
        //5 2
        //1 3 2 4 1

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        long k = scanner.nextInt();
        scanner.nextLine();
        String[] str = scanner.nextLine().split(" ");
        long[] list = Arrays.stream(str).mapToLong(Long::parseLong).toArray();
        Map<Long, Integer> map = new HashMap<>();
        long[] s = new long[m + 1];
        s[0] = 0;
        for (int i = 1; i <= m; i++) {
            s[i] += s[i - 1] + list[i - 1];
        }
        Integer[] array = {3, 1, 4, 1, 5, 9};
        Arrays.sort(array, Comparator.reverseOrder());

        int ans = 0;
        for (int i = 0; i <= m; i++) {
            if (!map.containsKey(s[i] - (long) k * i)){
                map.put(s[i] - (long) k * i, i);
            }else {
                ans = Math.max(i - map.get(s[i] - (long) k * i), ans);
            }
        }
        System.out.println(ans);

    }
}
