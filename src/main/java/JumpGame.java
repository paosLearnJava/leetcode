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
    public static void main(String[] args) {
        int [] test =new int[]{3,2,1,0,4};
        System.out.print(canJump(test));
    }
}
