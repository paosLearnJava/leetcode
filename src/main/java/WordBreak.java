import java.util.HashSet;
import java.util.List;
// 139. 单词拆分 Medium
// https://leetcode.cn/problems/word-break/submissions/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict =new HashSet(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&dict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
