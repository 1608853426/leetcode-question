//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足： 
//
// 
// 0 <= i, j, k, l < n 
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//输出：2
//解释：
//两个元组如下：
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length 
// n == nums2.length 
// n == nums3.length 
// n == nums4.length 
// 1 <= n <= 200 
// -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ 
// 
//
// Related Topics 数组 哈希表 👍 944 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

//java:四数相加 II

/***
 * 四数相加 II
 * 把四个数组分成两部分，A 和 B 为一组，C 和 D 为另外一组。
 * 对于 A 和 B，我们使用二重循环对它们进行遍历，得到所有 A[i]+B[j] 的值并存入 HashMap 中。
 * 对于 HashMap 中的每个键值对，每个键表示一种 A[i]+B[j]，对应的值为 A[i]+B[j] 出现的次数。
 * 对于 C 和 D，我们同样使用二重循环对它们进行遍历。
 * 当遍历到 C[k]+D[l] 时，如果 −(C[k]+D[l]) 出现在 HashMap 中，
 * 那么将 −(C[k]+D[l]) 对应的值累加进答案中。
 * 最终即可得到满足 A[i]+B[j]+C[k]+D[l]=0 的四元组数目。
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n^2)
 */
class P454FourSumIi{
    public static void main(String[] args){
        Solution solution = new P454FourSumIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums1){
            for (int y : nums2){
                map.put(x + y, map.getOrDefault(x + y, 0) + 1);
            }
        }
        int ans = 0;
        for(int x : nums3){
            for (int y : nums4){
                if (map.containsKey(0 - x - y)){
                    ans += map.get(0 - x - y);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}