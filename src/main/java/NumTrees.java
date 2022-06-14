// 96. 不同的二叉搜索树 Medium
// https://leetcode.cn/problems/unique-binary-search-trees/submissions/
public class NumTrees {
    public int numTrees(int n) {
        //下定义，再 公式硬推
        //G(n): 长度为 nn 的序列能构成的不同二叉搜索树的个数。
        //F(i, n): 以 i为根、序列长度为n的不同二叉搜索树个数 (1≤i≤n)。
        //G(n)=Sum(F(i,n))
        //F(i,n)=G(i-1)*G(n-i) {左*右}
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for (int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
