class Solution {
public:
    static string longestPalindrome(string& s) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            //odd
            auto [left_o, len_o] = check(i, i, s);
            //even
            auto [left_e, len_e] = check(i, i + 1, s);

            if (len < len_o) {
                len = len_o;
                index = left_o + 1;
            }
            if (len < len_e) {
                len = len_e;
                index = left_e + 1;
            }
        }
        return s.substr(index, len);
    }

    static std::tuple<int, int> check(int left, int right, string& s) {
        while (left >= 0 && right < s.length() && s[left] == s[right]) {
            left--;
            right++;
        }
        return { left, right - left - 1};
    }   
};