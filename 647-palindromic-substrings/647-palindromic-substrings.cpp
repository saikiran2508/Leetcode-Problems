class Solution {
public:
    int countSubstrings(string s) {
        int n = s.length();
        int dp[n][n];
        memset(dp, 0, sizeof(dp));
        int count = 0;
        for(int g = 0; g < n; g++){
            int i = 0;
            for(int j = g; j < n; j++){
                if(g == 0) dp[i][j] = 1;
                else if(g == 1){
                    if(s[i] == s[j]) dp[i][j] = 1;
                }
                else{
                    if(s[i] == s[j] && dp[i+1][j-1] == 1){
                        dp[i][j] = 1;
                    }
                }
                if(dp[i][j] == 1) count += 1;
                i++;
            }
        }
        return count;
    }
};