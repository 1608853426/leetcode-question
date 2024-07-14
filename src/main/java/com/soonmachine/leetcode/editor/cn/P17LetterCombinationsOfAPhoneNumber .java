//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2727 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//java:电话号码的字母组合

/**
 * 电话号码的字母组合
 * 1. 递归
 * 1. 递归终止条件：index==digits.length()
 * 2. 递归过程：从index开始遍历，path.add(i)，递归，path.remove(path.size()-1)
 * 3. 递归返回值：无
 * 时间复杂度：O(3^m * 4^n)
 * 空间复杂度：O(m+n)
 *
 */
class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            if(digits == null || digits.length() == 0) {
                return Collections.emptyList();
            }
            List<String> ans = new ArrayList<>();
            String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            dfs(digits,0,"",ans,map);
            return ans;
        }

        private void dfs(String digits, int index, String path, List<String> ans, String[] map) {
            if(index == digits.length()) {
                ans.add(path);
                return;
            }
            String letters = map[digits.charAt(index) - '0'];
            for (int i = 0; i < letters.length(); i++) {
                dfs(digits, index + 1, path + letters.charAt(i), ans, map);
            }




        }

        Map<Character, String> phoneMap;
        void dfs(List<String> res, StringBuilder sb, int index, String digits){
            if(index == digits.length()){
                res.add(new String(sb.toString()));
                return;
            }
            for(char c : phoneMap.get(digits.charAt(index)).toCharArray()){
                sb.append(c);
                dfs(res, sb, index + 1, digits);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}