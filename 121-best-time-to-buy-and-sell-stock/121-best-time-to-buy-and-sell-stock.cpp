class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<int> mn(n,0);
        vector<int> mx(n,0);
        mn[0] = prices[0];
        mx[n-1] = prices[n-1];
        for(int i = 1; i < n; i++){
            mn[i] = min(prices[i], mn[i-1]);
        }
        
        for(int i = n-2; i >= 0; i--){
            mx[i] = max(prices[i], mx[i+1]);
        }
        
        int ans = 0;
        for(int  i = 0; i < n; i++){
            ans = max(ans, mx[i]-mn[i]);
        }
        return ans;
    }
};