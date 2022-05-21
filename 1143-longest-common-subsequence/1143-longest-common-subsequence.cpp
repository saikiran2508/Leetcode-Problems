class Solution {
public:
    // int dp[1001][1001];
    // int LCS(string s, string t, int n, int m){
    //     if(n == 0 || m == 0) return 0;
    //     if(dp[n-1][m-1] != -1) return dp[n-1][m-1];
    //     if(s[n-1] == t[m-1]){
    //         return dp[n-1][m-1] = 1+LCS(s,t,n-1,m-1);
    //     }
    //     return dp[n-1][m-1] = max(LCS(s,t,n,m-1), LCS(s,t,n-1,m));
    // }
    int longestCommonSubsequence(string s, string t) {
        int n = s.length();
        int m = t.length();
        vector<vector<int>> dp(n+1, vector<int> (m+1, 0));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(s[i] == t[j]){
                    dp[i+1][j+1] = 1 + dp[i][j];
                }
                else{
                    dp[i+1][j+1] = max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[n][m];
        // return LCS(s,t,s.length(), t.length());
    }
}; 