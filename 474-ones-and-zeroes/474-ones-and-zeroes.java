class Solution {
    int dp[][][];
    public int findMaxForm(String[] arr, int m, int n) {
        dp = new int[m+1][n+1][arr.length];
        return solve(arr, m, n, 0);
    }
    public int solve(String[] arr, int zero, int one, int idx){
        if(idx == arr.length || zero+one == 0){
            return 0;
        }
        
        if(dp[zero][one][idx] > 0) return dp[zero][one][idx];
        
        int[] count = count(arr[idx]);
        
        int consider = 0;
        if(zero >= count[0] && one >= count[1]){
            consider = 1 + solve(arr, zero-count[0], one-count[1], idx+1);
        }
        int skip = solve(arr, zero, one, idx+1);
        return dp[zero][one][idx] = Math.max(consider, skip);
    }
    
    public int[] count(String s){
        int[] count = new int[2];
        for(char c: s.toCharArray()){
            count[c-'0']++;
        }
        return count;
    }
} 

