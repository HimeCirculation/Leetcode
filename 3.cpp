#include <unordered_map>
#include <algorithm>
#include <string>

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int length = s.length();
        int longest = 0;
        std::unordered_map<char, int> seen;
        int left = 0;
        for(int right=0; right<length;right++)
        {
            if(seen.count(s[right]) == 0 || left > seen[s[right]])
            {
                longest = std::max(longest, right-left + 1);
            }
            else
            {
                left = seen[s[right]] + 1;
            }
            seen[s[right]] = right;            
        }
        return longest;
    }
};