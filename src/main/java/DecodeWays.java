// 91. 解码方法 Medium
// https://leetcode.cn/problems/decode-ways/submissions/
public class DecodeWays {
    public static int numDecodings(String s) {
        int n=s.length();
        if(n<1){
            return n;
        }
        int a=0;
        int b=1;
        int c=0;
        // 次数计算 关键是边界值
        for(int i=0;i<n;i++){
            c=0;
            if(s.charAt(i)!='0'){
                c+=b;
            }
            if(i>=1&&s.charAt(i-1)!='0'&&(s.charAt(i-1)-'0')*10+(s.charAt(i)-'0')<=26){
                c+=a;
            }

            a=b;
            b=c;
        }
        return c;

    }
    public static void main(String[] args) {
        String test="27";
        String test1="226";
        String test2="0";
        System.out.print(numDecodings(test1));
    }
}
