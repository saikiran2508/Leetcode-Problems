class Solution {
public:
    int minimumLines(vector<vector<int>>& arr) {
        int n = arr.size();
        if(n==1) return 0;
        sort(arr.begin(), arr.end());
        
        int ans = 1;
        
        for(int i = 2; i < n; i++){
            long x1 = arr[i][0];
            long x2 = arr[i-1][0];
            long x3 = arr[i-2][0];
            
            long y1 = arr[i][1];
            long y2 = arr[i-1][1];
            long y3 = arr[i-2][1];
            
            long d1 = (y3-y2)*(x2-x1);
            long d2 = (y2-y1)*(x3-x2);
            if(d1 != d2) ans++;
        }
        return ans;
    }
};