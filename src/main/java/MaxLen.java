// 1567. 乘积为正数的最长子数组长度 Medium
// https://leetcode.cn/problems/maximum-length-of-subarray-with-positive-product/
public class MaxLen {
    public static int getMaxLen(int[] nums) {
        int minCount=0;
        int maxCount=0;
        int ret=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]==0){
                minCount=0;
                maxCount=0;
            }
            if(nums[i]>0){
                maxCount++;
                if(minCount!=0){
                    minCount++;
                }
            }
            if(nums[i]<0){
                int tmp=minCount;
                minCount=maxCount+1;
                if(tmp!=0){
                    maxCount=1+tmp;
                }else{
                    maxCount=0;
                }
            }
            if(ret<maxCount){
                ret=maxCount;
            }

        }
        return ret;
    }
    public static void main(String[] args) {
        int [] test =new int[]{0,1,-2,-3,-4};
        int [] test1 =new int[]{1,2,3,5,-6,4,0,10};
        System.out.print(getMaxLen(test1));
    }
}
