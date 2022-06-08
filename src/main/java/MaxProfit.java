// 完全没转移。。。
// 121. 买卖股票的最佳时机 easy
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
// 122. 买卖股票的最佳时机 II Medium
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/

// 309. 最佳买卖股票时机含冷冻期 Medium
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/

// 714. 买卖股票的最佳时机含手续费 Medium
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int min=prices[0];
        int max=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]-min<0){
                min=prices[i];
            }
            if(prices[i]-min>max){
                max=prices[i]-min;
            }
        }
        return max;
    }
    public static int maxProfit2(int[] prices) {
        int max=0;
        for(int i=1;i<prices.length;i++)  {
            if(prices[i]>prices[i-1]){
                max=max+prices[i]-prices[i-1];
            }
        }
        return max;
    }

    // m蒙了
    public static int maxProfit3(int[] prices){
        int n = prices.length;
        if (n==0){
            return 0;
        }
        int[][] dp = new int[n][3];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        dp[0][2]=0;
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1]=dp[i-1][0]+prices[i];
            dp[i][2]=Math.max(dp[i-1][1],dp[i-1][2]);
        }

        return Math.max(dp[n-1][1],dp[n-1][2]);
    }


    public static int maxProfit4(int[] prices, int fee) {
        int preOn=-prices[0];//持有
        int preOff=0;//空空
        int on=0;
        int off=0;
        for(int i=0;i<prices.length;i++){
            on=Math.max(preOn,preOff-prices[i]);
            off=Math.max(preOff,preOn+prices[i]-fee);
            preOn=on;
            preOff=off;
        }
        return off;
    }
    //amazing
    public static int cleverMaxProfit4(int[] prices, int fee) {
        int n = prices.length;
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < n; ++i) {
            sell = Math.max(sell, buy + prices[i] - fee);
            System.out.print("sell:");
            System.out.println(sell);

            buy = Math.max(buy, sell - prices[i]);
            System.out.print("buy:");
            System.out.println(buy);

        }
        return sell;
    }
        public static void main(String[] args) {
//        int [] test =new int[]{7,1,5,3,6,4};
//        System.out.print(maxProfit(test));
        int [] test1=new int[]{1, 3, 2, 8, 4, 9};
            System.out.print(cleverMaxProfit4(test1,2));

        }
}
