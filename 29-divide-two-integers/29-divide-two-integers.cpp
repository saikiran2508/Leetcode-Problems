class Solution {
public:
   int divide(int dividend, int divisor) {
        int flag = 0;
        long long divd = dividend;
        long long divs = divisor;
        // if the result is negative value
        if((divd > 0 && divs < 0) || (divd < 0 && divs > 0)) {
            flag = 1;            
        }
        // change negative value to positive value
        if(divs < 0) divs = (~divs) + 1;
        if(divd < 0 ) divd = (~divd) + 1;
        
        long long max_val = (1LL<<31) - 1; // allowed max value
        long long min_val = -(1LL<<31); // allowed min_value
        long long sum = 0; // quotient
        long long cnt = 1; // multiplier
        long long val = divs; // multiplier * devisor
        while(divd >= divs) {
            if(divd < val) {
                cnt = 1;
                val = divs;
            }
                
            sum += cnt;
            divd -= val;
            cnt += cnt; // 2^(cnt-1)
            val += val; // val = cnt * divisor   
        }    
                        
        int ans = 0;
        if(flag == 1) sum = (~sum) + 1; // if result is negative
        if(sum > max_val) ans = max_val; // if quotient is greater than max
        else if(sum < min_val) ans = min_val; // if quotient is less than min
        else ans = sum; // else
        return ans;
    }
};