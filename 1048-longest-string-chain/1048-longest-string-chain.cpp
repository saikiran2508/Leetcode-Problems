class Solution {
public:
    
    static bool comp(string s1, string s2){
        return s1.length() < s2.length();
    }  
    
    bool compare(string a,string b){
        int count = 0;
        int index = 0;
        for(int i = 0 ; i < a.size() and index < b.size(); i++,index++){
            if(a[i] != b[index]){
                count++;
                i--;
            }
            if(count > 1) return false;
        }
        return count <= 1;
    }
    int longestStrChain(vector<string>& arr) {
        sort(arr.begin(), arr.end(), comp);
        int n = arr.size();
        if(n == 1) return 1;
        vector<int> dp(n,1);
        int maxi = 1;
        for(int i = 0; i < n; i++){
            for(int j = i-1; j >= 0 && arr[j].size() + 1 >= arr[i].size(); j--){
                if(arr[j].size() == arr[i].size()-1){
                    if(compare(arr[j], arr[i])){
                        dp[i] = max(dp[i], dp[j]+1);
                    }
                }
            }
        }
        for(auto i: dp) maxi = max(i, maxi);
        return maxi;
    }
};