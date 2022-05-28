class Solution {
public:
    int missingNumber(vector<int>& nums) {
        unordered_set<int> st;
        for(auto i: nums) st.insert(i);
        for(int i = 0; i < nums.size(); i++){
            if(st.find(i) == st.end()) return i;
        }
        return nums.size();
    }
};