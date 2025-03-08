class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Binary search for different length prefixes and check if they are common to all words
        int low = 0, high = strs[0].length();

        while (low < high) {
            int mid = (low + high + 1) / 2; // Midpoint length

            if (isCommonPrefix(strs, mid)) {
                low = mid; // Move right if prefix exists
            } else {
                high = mid - 1; // Move left if prefix fails
            }
        }

        return strs[0].substring(0, low);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (String word : strs) {
            if (!word.startsWith(prefix)) return false;
        }
        return true;
    }
}
