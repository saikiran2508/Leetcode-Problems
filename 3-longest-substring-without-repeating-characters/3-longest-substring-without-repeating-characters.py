class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        start = 0
        maxLen = 0
        myset = {}

        for i in range(len(s)):
            if s[i] in myset and start <= myset[s[i]]:
                start = myset[s[i]]+1
            else:
                maxLen = max(maxLen, i-start+1)
            myset[s[i]] = i
        return maxLen