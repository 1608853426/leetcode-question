//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4303 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:有效的括号

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * 1. 用栈，遇到左括号就入栈，遇到右括号就出栈，如果出栈的元素和右括号不匹配，就返回false
 * 2. 如果最后栈为空，就返回true
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class P20ValidParentheses{
    public static void main(String[] args){
        Solution solution = new P20ValidParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for (char c : s.toCharArray()){
            if (map.containsValue(c)){
                stack.push(c);
            }else {
                if (stack.isEmpty() || !map.get(c).equals(stack.pop())){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}