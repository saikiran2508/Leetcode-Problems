class Solution {
public:
    
    vector<int> LBS(vector<int> &arr, int n){
        vector<int> dp(n,1);
        int maxi = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = max(dp[i], 1 + dp[j]);
                }
            }
        }
        return dp;
    }
    
    vector<int> reverseLBS(vector<int> &arr, int n){
        vector<int> dp(n,1);
        
        for(int i = n-1; i >= 0; i--){
            for(int j = n-1; j > i; j--){
                if(arr[j] < arr[i]){
                    dp[i] = max(dp[i], 1 + dp[j]);
                }
            }
        }
        
        return dp;
    }
    
    int minimumMountainRemovals(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp1 = LBS(nums, n);
        vector<int> dp2 = reverseLBS(nums, n);
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(dp1[i] > 1 && dp2[i] > 1)ans = max(ans, dp1[i] + dp2[i] - 1);
        }
        return n-ans;
    }
};