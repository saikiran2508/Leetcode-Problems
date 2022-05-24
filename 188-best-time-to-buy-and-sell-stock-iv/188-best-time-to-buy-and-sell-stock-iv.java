class Solution {
    int dp[][][];
    public int solve(int[] prices, int idx, int buy, int cap){
        if(idx >= prices.length || cap <= 0) return 0;
        if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];
        int m1 = 0;
        if(buy == 1){
            m1 = Math.max(solve(prices, idx+1, 1-buy, cap) - prices[idx],
                    solve(prices, idx+1, buy, cap)
                    );
        }
        else{
            m1 = Math.max(solve(prices, idx+1, 1-buy, cap-1) + prices[idx],
                    solve(prices, idx+1, buy, cap)
                    );
        }
        return dp[idx][buy][cap] = m1;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp = new int[n][2][k+1];
        for(int[][] arr: dp){
            for(int[] a: arr){
                Arrays.fill(a,-1);
            }
        }
        return solve(prices, 0, 1, k);
    }
} 