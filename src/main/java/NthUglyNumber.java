// 264. 丑数 II Medium
// https://leetcode.cn/problems/ugly-number-ii/submissions/
public class NthUglyNumber {
    // 三个指针p2，p3，p5，实际上pi的含义是有资格同i相乘的最小丑数的位置。
    public int nthUglyNumber(int n) {
        int p2=1,p3=1,p5=1;
        int[] dp=new int[n+1];
        dp[1]=1;
        // 边界值从1开始
        for(int i=2;i<=n;i++){
            int n2=dp[p2]*2,n3=dp[p3]*3,n5=dp[p5]*5;
            dp[i]=Math.min(Math.min(n2,n3),n5);
            if(dp[i]==n2){
                p2++;
            }
            if(dp[i]==n3){
                p3++;
            }
            if(dp[i]==n5){
                p5++;
            }
        }
        return dp[n];
    }
}
