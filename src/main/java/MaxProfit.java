// 完全没转移。。。
// 121. 买卖股票的最佳时机 easy
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
// 122. 买卖股票的最佳时机 II Medium
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
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
    public static void main(String[] args) {
        int [] test =new int[]{7,1,5,3,6,4};
        System.out.print(maxProfit(test));
    }
}
