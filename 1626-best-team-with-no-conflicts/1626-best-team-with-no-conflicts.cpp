class Solution {
public:
    int bestTeamScore(vector<int>& scores, vector<int>& ages) {
        vector<vector<int>> arr;
        int n = scores.size();
        for(int i = 0; i < n; i++){
            arr.push_back({ages[i], scores[i]});
        }
        sort(arr.begin(), arr.end(), greater<>());
        
        vector<int> dp(n,0);
        
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            int score = arr[i][1];
            dp[i] = score;
            for(int j = 0; j < i; j++){
                if(arr[j][1] >= arr[i][1]){
                    dp[i] = max(dp[i], score+dp[j]);
                }
            }
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};