class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        
        if(n == 0) return 0;
        if(n == 1) return 1;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        
        int count[] = new int[n];
        Arrays.fill(count, 1);
        
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                    else if(dp[j] + 1 == dp[i]){
                        count[i] += count[j];
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == max){
                res += count[i];
            }
        }
        return res;
    }
}