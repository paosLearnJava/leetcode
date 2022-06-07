// 1014. 最佳观光组合 Medium
// https://leetcode.cn/problems/best-sightseeing-pair/submissions/
public class MaxScoreSightseeingPair {

    public int maxScoreSightseeingPair(int[] values) {
        int ret=0;
        int max=0;
        for (int i=0;i<values.length-1;i++){
            max=Math.max(max,values[i]+i);
            ret=Math.max(ret,max+values[i+1]-(i+1));
        }
        return ret;
    }
}

