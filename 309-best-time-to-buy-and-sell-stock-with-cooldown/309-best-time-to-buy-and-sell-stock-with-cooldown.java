class Solution {
    int dp[][];
    public int solve(int[] prices, int idx, int buy){
        if(idx >= prices.length) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy];
        int m = 0;
        if(buy == 1){
            m = Math.max(solve(prices, idx+1, 1-buy)-prices[idx], 
                        solve(prices, idx+1, buy));
        }
        else{
            m = Math.max(solve(prices, idx+2, 1-buy)+prices[idx],
                        solve(prices, idx+1, buy));
        }
        return dp[idx][buy] = m;
    }
    
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return solve(prices, 0, 1);
    }
}