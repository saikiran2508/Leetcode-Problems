class Solution {
public:
    int dp[101][101][201];
    bool solve(string s1, string s2, string s3, int i, int j, int k){
        if(dp[i][j][k] != -1) return dp[i][j][k];
        if(i == s1.length() && j == s2.length() && k == s3.length()) return true;
        bool r = false;
        if(i < s1.length()){
            if(s1[i] == s3[k])
                r = r | solve(s1, s2, s3, i+1, j, k+1);
        }
        
        if(j < s2.length()){
            if(s2[j] == s3[k])
                r = r | solve(s1, s2, s3, i, j+1, k+1);
        }
        return dp[i][j][k] = r;
    }
    
    bool isInterleave(string s1, string s2, string s3) {
        memset(dp, -1, sizeof(dp));
        return solve(s1, s2, s3, 0,0,0);
    }
};