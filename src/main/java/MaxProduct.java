// 152. 乘积最大子数组 Medium
// https://leetcode.cn/problems/maximum-product-subarray/
public class MaxProduct {
    public static int maxProduct(int[] nums) {
        int preMin=nums[0];
        int min=nums[0];
        int preMax=nums[0];
        int max=nums[0];
        int ret=nums[0];
        for(int i=1;i<nums.length;i++){
            min=Math.min(nums[i],Math.min(preMin*nums[i],preMax*nums[i]));
            max=Math.max(nums[i],Math.max(preMin*nums[i],preMax*nums[i]));
            preMin=min;
            preMax=max;
            if(ret<max){
                ret=max;
            }
        }
        return ret;
    }
    public static int cleverMaxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            //临时变量 即可
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
        public static void main(String[] args) {
        int [] test =new int[]{2,3,-2,4};
        int [] test1 =new int[]{-2,0,-1};
        System.out.print(maxProduct(test1));
    }
}
