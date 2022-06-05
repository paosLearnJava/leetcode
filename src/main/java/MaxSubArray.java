// 53. 最大子数组和 easy
// https://leetcode.cn/problems/maximum-subarray/

public class MaxSubArray {
    public static int maxSubArray(int[] nums){
        int n=nums.length;
        int max=nums[0];
        int sum=0;
        for(int i=0;i<n;i++){
            // note!
            if(sum+nums[i]<nums[i]){
                sum=nums[i];
            }else{
                sum=sum+nums[i];
            }
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }
    public static int cleverMaxSubArray(int[] nums){
        int pre =0, maxAns=nums[0];
        for (int x : nums) {
            pre=Math.max(x,pre+x);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }
    public static void main(String[] args) {
        int [] test =new int[]{5,4,-1,7,8};
        int [] test1 =new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int [] test2 =new int[]{-1};
        System.out.print(maxSubArray(test1));
    }
}
