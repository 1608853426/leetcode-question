//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例： 
//
// 输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 20000 
// S 仅由小写英文字母组成。 
// 
//
// Related Topics 栈 字符串 👍 600 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:删除字符串中的所有相邻重复项

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除字符串中的所有相邻重复项
 * 栈实现
 * 1. 遍历字符串，如果栈为空，就入栈，如果栈不为空，就判断栈顶元素和当前元素是否相等，如果相等就出栈，如果不相等就入栈
 * 2. 最后将栈中的元素转成字符串返回
 */
class P1047RemoveAllAdjacentDuplicatesInString{
    public static void main(String[] args){
        Solution solution = new P1047RemoveAllAdjacentDuplicatesInString().new Solution();
        String s = solution.removeDuplicates("abbaca");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()){
            if (!stack.isEmpty() && stack.peekLast() == c){
                stack.pollLast();
            }else {
                stack.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        stack.stream().map(String::valueOf).forEach(sb::append);
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}