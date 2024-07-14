//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列
// beginWord -> s1 -> s2 -> ... -> sk： 
//
// 
// 每一对相邻的单词只差一个字母。 
// 
// 对于 1 <= i <= k 时，每个
// si 都在
// wordList 中。注意， beginWord 不需要在
// wordList 中。
// 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 
//中的 单词数目 。如果不存在这样的转换序列，返回 0 。 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
//
// Related Topics 广度优先搜索 哈希表 字符串 👍 1347 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.*;

//java:单词接龙
class P127WordLadder {
    public static void main(String[] args) {
        Solution solution = new P127WordLadder().new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        solution.ladderLength(beginWord, endWord, wordList);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Map<String, Integer> map = new HashMap<>();
            map.put(beginWord, 1);
            if (!wordList.contains(endWord)) {
                return 0;
            }
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);

            while (!queue.isEmpty()) {
                String word = queue.poll();
                int path = map.get(word);
                for (String s : wordList) {
                    if (canTransform(word, s) && !map.containsKey(s)) {
                        if (s.equals(endWord)) {
                            return path + 1;
                        }
                        map.put(s, path + 1);
                        queue.offer(s);
                    }
                }
            }
            return 0;
        }

        boolean canTransform(String a, String b) {
            if (a.length() != b.length()){
                return false;
            }
            int diff = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    diff++;
                }
            }
            return diff == 1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
}