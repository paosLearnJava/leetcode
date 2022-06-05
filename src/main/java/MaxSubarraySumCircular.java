import java.util.Deque;
import java.util.LinkedList;

// 918. 环形子数组的最大和 medium
// https://leetcode.cn/problems/maximum-sum-circular-subarray/
public class MaxSubarraySumCircular {
    public static int maxSubarraySumCircular(int[] nums) {
        // copy
        int total=0,pre1=0,pre2=0,max=nums[0],min=nums[0];
        for(int i=0;i<nums.length;i++){
            pre1=Math.max(pre1+nums[i],nums[i]);
            max=Math.max(max,pre1);
            pre2=Math.min(pre2+nums[i],nums[i]);
            min=Math.min(pre2,min);
            total=total+nums[i];
        }
        return max>0?Math.max(max,total-min):max;
    }


//更通俗一个解法

    /**
     * 考察三个知识点：
     *
     * 1、破环成链。
     *
     * 由于是环形数组，则数组的末端会与开头相连呈环状。
     *
     * 只需要将长度为N的数组拷贝一次，拼接在原数组后，即得到长度为2N的数组，该数组即为环形数组。
     *
     * 如：原数组为123，则原数组为环形数组123123的子集。
     *
     * 2、前缀和。
     *
     * 要求环形数组中子数组的最大和，只需要求长度为2N的数组中长度不超过N的子数组的最大和。
     *
     * 构造前缀和后，求前缀和，即以右端点i与左端点j + 1所构成的子数组的最大和为Si - Sj 。
     *
     * 3、单调队列（滑动窗口）。
     *
     * 滑动窗口的左端点为j，右端点为i，但需要维护j + 1到i，故窗口长度为i - j + 1 - 1 → i - j ≤ N。
     *
     * 由于求Si - Sj 最大，且Si是固定值，故Sj应该最小，即滑动窗口维护区间 S(j, i] 的最小值。
     *
     * 时间复杂度：O(n) ；空间复杂度：O(n) 。
     *
     * 作者：xuanmichael_cn
     * 链接：https://leetcode.cn/problems/maximum-sum-circular-subarray/solution/by-xuanmichael_cn-fxu6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     */
    public static int maxSubarraySumCircularToLearn(int[] nums) {
        int n = nums.length, m = n << 1;
        int[] sum = new int[m + 1];
        for (int i = 1; i <= m; ++i) {
            sum[i] = sum[i - 1] + nums[(i - 1) % n];
        }
        Deque<Integer> q = new LinkedList<>();
        q.add(0);
        int max = nums[0];
        for (int i = 1; i <= m; ++i) {
            if (!q.isEmpty() && q.peek() < i - n) {
                q.poll();
            }
            max = Math.max(max, sum[i] - sum[q.peek()]);
            while (!q.isEmpty() && sum[q.peekLast()] > sum[i]) {
                q.pollLast();
            }
            q.add(i);
        }
        return max;
    }

}
