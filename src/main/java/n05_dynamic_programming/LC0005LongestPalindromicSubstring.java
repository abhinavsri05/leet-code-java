package n05_dynamic_programming;

public class LC0005LongestPalindromicSubstring
{
    // Leetcode discussion
    /*
    https://leetcode.com/problems/longest-palindromic-substring/discuss/1897717/Java-dynamic-programming
     */
    public String longestPalindrome(String s)
    {
        String r = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(j - i + 1 < 3){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i+1][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                }
                if(dp[i][j] && j - i + 1 > r.length()){
                    r = s.substring(i, j + 1);
                }
            }
        }
        return r;
    }
}
