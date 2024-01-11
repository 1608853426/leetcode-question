//给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。 
//
//
// 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。 
//
//
// 
// 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。 
// 
//
// 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。 
//
// 
//
// 示例 1： 
// 
// 
//输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//输出：["JFK","MUC","LHR","SFO","SJC"]
// 
//
// 示例 2： 
// 
// 
//输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL",
//"SFO"]]
//输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tickets.length <= 300 
// tickets[i].length == 2 
// fromi.length == 3 
// toi.length == 3 
// fromi 和 toi 由大写英文字母组成 
// fromi != toi 
// 
//
// Related Topics 深度优先搜索 图 欧拉回路 👍 875 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.*;

//java:重新安排行程


/**
 * 重新安排行程
 * 1. 回溯
 * 1. 回溯终止条件：res.size() == tickets.size() + 1
 * 2. 回溯过程：从res的最后一个元素开始，如果map中包含该元素，遍历该元素的value，如果value>0，说明该元素还有剩余，将该元素加入res，value-1，递归，递归完成后，将该元素移除，value+1
 * 3. 回溯返回值：无
 * 时间复杂度：O(n*2^n)
 * 空间复杂度：O(n)
 */
class P332ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new P332ReconstructItinerary().new Solution();
        //[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));
        solution.findItinerary(tickets);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Deque<String> res;
        private Map<String, Map<String, Integer>> map;

        private boolean backTracking(int ticketNum){
            if(res.size() == ticketNum + 1){
                return true;
            }
            String last = res.getLast();
            if(map.containsKey(last)){//防止出现null
                for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                    int count = target.getValue();
                    if(count > 0){
                        res.add(target.getKey());
                        target.setValue(count - 1);
                        if(backTracking(ticketNum)) return true;
                        res.removeLast();
                        target.setValue(count);
                    }
                }
            }
            return false;
        }

        public List<String> findItinerary(List<List<String>> tickets) {
            map = new HashMap<String, Map<String, Integer>>();
            res = new LinkedList<>();
            for(List<String> t : tickets){
                Map<String, Integer> temp;
                if(map.containsKey(t.get(0))){
                    temp = map.get(t.get(0));
                    temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
                }else{
                    temp = new TreeMap<>();//升序Map
                    temp.put(t.get(1), 1);
                }
                map.put(t.get(0), temp);

            }
            res.add("JFK");
            backTracking(tickets.size());
            return new ArrayList<>(res);
        }


}
//leetcode submit region end(Prohibit modification and deletion)

}