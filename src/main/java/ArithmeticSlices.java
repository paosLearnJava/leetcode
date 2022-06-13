// 413. 等差数列划分 Medium
// https://leetcode.cn/problems/arithmetic-slices/
public class ArithmeticSlices {
    // 关键是计算公式
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length<3){
            return 0;
        }
        int d=nums[1]-nums[0];
        int t=0;
        int ret=0;
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==d){
                t=t+1;
                ret=ret+t;
            }else{
                t=0;
                d=nums[i]-nums[i-1];
            }
        }
        return ret;
    }
}
