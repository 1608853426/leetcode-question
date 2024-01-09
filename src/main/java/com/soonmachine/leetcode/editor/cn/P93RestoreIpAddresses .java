//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1375 👎 0

package com.soonmachine.leetcode.editor.cn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//java:复原 IP 地址

/**
 * 复原IP 地址
 * 递归
 * 1. 递归终止条件：index==s.length() && path.size()==4
 * 2. 递归过程：从index开始遍历，path.add(i)，递归，path.remove(path.size()-1)
 * 3. 递归返回值：无
 * 时间复杂度：O(3^m * 4^n)
 * 空间复杂度：O(m+n)
 */
class P93RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new P93RestoreIpAddresses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            if (s.length() < 4 || s.length() > 12){
                return Collections.emptyList();
            }
            List<String> ans = new ArrayList<>();
            List<String> path = new ArrayList<>();
            dfs(0, s, ans, path);
            return ans;
        }

        void dfs(int startIndex, String s, List<String> ans, List<String> path){
            if (startIndex == s.length() && path.size() == 4){
                StringBuilder sb = new StringBuilder();
                path.forEach(a -> {
                    sb.append(a);
                    sb.append(".");
                });
                sb.deleteCharAt(sb.length() - 1);
                ans.add(sb.toString());
            }
            for (int i = startIndex; i < s.length(); i++) {
                if (isValid(s.substring(startIndex, i + 1))){
                    path.add(s.substring(startIndex, i + 1));
                    dfs(i + 1,s, ans, path);
                    path.remove(path.size() - 1);
                }
            }
        }


        boolean isValid(String s){
            if (s.length() > 3 || s.length() == 0){
                return false;
            }
            if (s.length() > 1 && s.charAt(0) == '0'){
                return false;
            }
            //s可能包含字母，如果包含字母，会抛出NumberFormatException
            int num = -1;
            try {
                num = Integer.parseInt(s);
            }catch (NumberFormatException e){
                return false;
            }
            return num >= 0 && num <= 255;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}