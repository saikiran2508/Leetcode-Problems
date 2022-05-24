class Solution {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][3];
        
//         for(int idx = 0; i <= n; i++){
//             for(int b = 0; b < 2; b++){
//                 dp[idx][b][0] = 0;
//             }
//         }
        
//         for(int b = 0; b < 2; b++){
//             for(int c = 0; c < 3; c++){
//                 dp[n][b][c] = 0;
//             }
//         }
        
        for(int i = n-1; i >= 0; i--){
            for(int b = 0; b < 2; b++){
                for(int c = 1; c < 3; c++){
                    if(b == 1){
                        dp[i][b][c] = Math.max(dp[i+1][1-b][c] - prices[i], dp[i+1][b][c]);
                    }
                    else{
                        dp[i][b][c] = Math.max(dp[i+1][1-b][c-1]+prices[i], dp[i+1][b][c]);
                    }
                }
            }
        }
        return dp[0][1][2];
        
        
    }
}