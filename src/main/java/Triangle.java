// 118. 杨辉三角 Easy
// https://leetcode.cn/problems/pascals-triangle/

import java.util.ArrayList;
import java.util.List;

// 119. 杨辉三角 II Easy
// https://leetcode.cn/problems/pascals-triangle-ii/
public class Triangle {
    // I 边界值 从0开始 否则会楚姐
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        if (numRows==0){
            return ret;
        }
        for(int i=0;i<numRows;i++){
            List<Integer> tmp = new ArrayList<Integer>();
            for (int j=0;j<=i;j++){
                if(j==0||j==i){
                    tmp.add(1);
                }else{
                    tmp.add(ret.get(i-1).get(j-1)+ ret.get(i - 1).get(j));
                }
            }
            ret.add(tmp);

        }
        return ret;

    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> cur = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return  pre;
    }
}
