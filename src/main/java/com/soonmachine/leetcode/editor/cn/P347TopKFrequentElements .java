//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1758 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:前 K 个高频元素

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前 K 个高频元素
 * 1. 用map统计每个元素出现的次数
 * 2. 用小顶堆，遍历map，如果堆的元素个数小于k，就直接入堆，如果堆的元素个数等于k，就比较堆顶元素和当前元素的大小，如果堆顶元素大，就出堆，当前元素入堆
 * 3. 最后返回堆中的元素
 * 时间复杂度：O(nlogk)
 * 空间复杂度：O(n)
 */
class P347TopKFrequentElements{
    public static void main(String[] args){
        Solution solution = new P347TopKFrequentElements().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() < k){
                queue.offer(new int[]{num, count});
            }else {
                if (queue.peek()[1] < count){
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            }
        }
        return queue.stream().mapToInt(o -> o[0]).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}