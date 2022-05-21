class Solution {
public:
    int ceilBS(vector<int> store, int n, int k){
        
        int start = 0, end = n;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(store[mid] == k){
                return mid;
            }
            else if(store[mid] < k) start = mid+1;
            else end = mid-1;
        }
        return start;
    }
    int lengthOfLIS(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        int n = nums.size();
        vector<int> store(n);
        store[0] = nums[0];
        int len = 0;
        for(int i = 1; i < nums.size(); i++){
            if(nums[i] > store[len]){
                store[++len] = nums[i];
            }
            else{
                int idx = ceilBS(store, len, nums[i]);
                store[idx] = nums[i];
            }
        }
        return len+1;
    }
};