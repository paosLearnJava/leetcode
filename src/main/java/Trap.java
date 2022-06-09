import java.util.Deque;
import java.util.LinkedList;

// 42. 接雨水 hard
// https://leetcode.cn/problems/trapping-rain-water/
public class Trap {
    public int trap(int[] height) {
        Deque<Integer> stk= new LinkedList<Integer>();
        int ans=0;
        for(int i=0;i<height.length;i++){
            // while循环可以一直去算面积 绝对想不到
            while(!stk.isEmpty()&&height[i]>height[stk.peek()]){
                int pre=stk.pop();
                int flr=height[pre];
                // 为空 跳出循环
                if(stk.isEmpty()){
                    break;
                }
                int left=stk.peek();
                int wt=i-left-1;
                int ht=Math.min(height[i],height[left])-flr;
                ans=ans+wt*ht;
            }
            stk.push(i);
        }
        return ans;
    }
}
