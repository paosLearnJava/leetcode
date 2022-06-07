// 55. 跳跃游戏 Medium
// https://leetcode.cn/problems/jump-game/
// 56. 跳跃游戏 II Medium
// https://leetcode.cn/problems/jump-game-ii/
public class JumpGame {
    public static boolean canJump(int[] nums) {
        int l=nums.length;
        int end=l-1;
        int max=nums[0];
        for(int i=0;i<=max&&i<l;i++){
            max=Math.max(max,i+nums[i]);
            if(max>=end){
                return true;
            }
            if(max==i){
                return false;
            }
        }

        return false ;
    }


    public static int jump2(int[] nums) {
        int end=nums.length-1;
        int index=0;
        int step=0;
        int nextMax=0;
        int nextIndex=0;
        int max=0;

        while (index<end){
            nextIndex=index+1;
            step++;
            max=index+nums[index];
            if(max>=end){
                return step;
            }

            for(int i=nextIndex;i<=max && i<end;i++){
                System.out.println(i);
                if(i+nums[i]>=end){
                    return ++step;
                }
                if(nextMax<i+nums[i]){
                    nextIndex=i;
                    nextMax=i+nums[i];
                }
            }
            index=nextIndex;

        }
        return step;
    }
    public static int cleverJump2(int[] nums){
        int step=0;
        int max=0;
        int index=0;
        for(int i=0;i<nums.length-1;i++){
            if(max<nums[i]+i){
                max=nums[i]+i;
            }
            if(i==index){
                index=max;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int [] test =new int[]{3,2,1,0,4};


        int [] test1 =new int[]{2,3,1,1,4};
        int [] test2 =new int[]{1,2};
        int [] test3 =new int[]{0};
        int [] test4 =new int[]{1,2,3};
        int [] test5 =new int[]{3,2,1};
        int [] test6 =new int[]{2,3,1};

        System.out.print(canJump(test));
    }
}
