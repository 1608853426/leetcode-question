//给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。 
//
// 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。 
//
// 返回一个表示每个字符串片段的长度的列表。 
//
// 
//示例 1：
//
// 
//输入：s = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。 
//
// 示例 2： 
//
// 
//输入：s = "eccbbbbdec"
//输出：[10]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 双指针 字符串 👍 1087 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//java:划分字母区间

/**
 * 划分字母区间
 * 1. 贪心
 * 贪心策略：统计每个字母最后出现的位置，然后遍历字符串，如果当前字母的最后出现位置等于当前位置，那么当前位置就是一个划分区间的结束位置
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 */
class P763PartitionLabels{
    public static void main(String[] args){
        Solution solution = new P763PartitionLabels().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
        if (s.length() == 1){
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, last[s.charAt(i) - 'a']);
            if (i == right){
                ans.add(right - left + 1);
                left = i + 1;
            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}