//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1821 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.*;
import java.util.stream.Collectors;

//java:字母异位词分组
class P49GroupAnagrams{
    public static void main(String[] args){
        Solution solution = new P49GroupAnagrams().new Solution();
        //["eat","tea","tan","ate","nat","bat"]
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = solution.groupAnagrams(strs);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            int[] arr = new int[26];
            for (char c : str.toCharArray()){
                arr[c - 'a'] ++;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0){
                    char c = (char) ('a' + i);
                    String s = String.valueOf(c) + arr[i];
                    key.append(s);
                }
            }
            if (!map.containsKey(key.toString())){
                map.put(key.toString(), new ArrayList<>());
            }
            List<String> strings = map.get(key.toString());
            strings.add(str);
        }

        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}