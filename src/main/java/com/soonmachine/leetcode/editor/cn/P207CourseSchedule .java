//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1887 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:课程表

/**
 * 课程表
 * 1. 拓扑排序
 *  首先构建邻接表和入度数组
 *  1.1 邻接表：使用二维数组存储图的边
 *  1.2 入度数组：使用一维数组存储每个节点的入度
 *  1.3 遍历所有节点，将入度为0的节点加入队列
 *  1.4 遍历队列，将队列中的节点出队，将节点的所有邻接节点的入度减1，如果邻接节点的入度为0，将邻接节点加入队列
 *  1.5 如果队列为空，返回true，否则返回false
 *  时间复杂度：O(n+m)
 *  空间复杂度：O(n+m)
 *  2. 深度优先搜索
 *  使用一维数组标记节点的状态
 *  2.1 0：未搜索
 *  2.2 1：搜索中
 *  2.3 2：已完成
 *  2.4 遍历所有节点，如果节点未搜索，从该节点开始深度优先搜索
 *  2.5 如果搜索过程中遇到搜索中的节点，说明存在环，返回false
 *  2.6 如果搜索过程中遇到已完成的节点，说明无环，返回true
 *  时间复杂度：O(n+m)
 *  空间复杂度：O(n+m)
 */

class P207CourseSchedule{
    public static void main(String[] args){
        Solution solution = new P207CourseSchedule().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //one dimension array to store the status of the node
        //0: not searched
        //1: searching
        //2: searched
        int[] status;
        boolean valid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       status = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(status[i] == 0){
                dfs(i, prerequisites);
            }
        }
        return valid;
    }

        private void dfs(int i, int[][] prerequisites) {
            status[i] = 1;
            for (int j = 0; j < prerequisites.length; j ++){
                if (prerequisites[j][1] == i){
                    if(status[prerequisites[j][0]] == 0){
                        dfs(prerequisites[j][0], prerequisites);
                        if(!valid){
                            return;
                        }
                    }else if(status[prerequisites[j][0]] == 1){
                        valid = false;
                        return;
                    }
                }
            }
            status[i] = 2;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}