//有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示
//水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
//
// 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足
//xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
//
// 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
//
// 示例 1：
//
//
//输入：points = [[10,16],[2,8],[1,6],[7,12]]
//输出：2
//解释：气球可以用2支箭来爆破:
//-在x = 6处射出箭，击破气球[2,8]和[1,6]。
//-在x = 11处发射箭，击破气球[10,16]和[7,12]。
//
// 示例 2：
//
//
//输入：points = [[1,2],[3,4],[5,6],[7,8]]
//输出：4
//解释：每个气球需要射出一支箭，总共需要4支箭。
//
// 示例 3：
//
//
//输入：points = [[1,2],[2,3],[3,4],[4,5]]
//输出：2
//解释：气球可以用2支箭来爆破:
//- 在x = 2处发射箭，击破气球[1,2]和[2,3]。
//- 在x = 4处射出箭，击破气球[3,4]和[4,5]。
//
//
//
//
//
//
// 提示:
//
//
// 1 <= points.length <= 10⁵
// points[i].length == 2
// -2³¹ <= xstart < xend <= 2³¹ - 1
//
//
// Related Topics 贪心 数组 排序 👍 921 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.Arrays;
import java.util.Comparator;

//java:用最少数量的箭引爆气球

/**
 * 用最少数量的箭引爆气球
 * 1. 贪心
 * 贪心策略：先按照气球的左边界排序，然后从左到右遍历，如果当前气球的左边界大于上一支箭的射击位置，那么需要增加一支箭
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(logn)
 */
class P452MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        Solution solution = new P452MinimumNumberOfArrowsToBurstBalloons().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0){
                return 0;
            }
            Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
            int result = 1;
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] > points[i - 1][1]){
                    result ++;
                }else {
                    points[i][1] = Math.min(points[i][1], points[i -1][1]);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}