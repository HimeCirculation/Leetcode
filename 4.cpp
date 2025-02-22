class Solution {
public:
    static double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        /* PLAN
        For each value in shortest array:
            >search for the two values in longest array where the value belongs, insert.
            >the arrays are sorted so we know the next value must belong to the right of the previous
            >therefore we can search the longest array from the index of the previous value to the end for the position of
            the new value, insert
            >return median value
        */

        vector<int>* shortest;
        vector<int>* longest;

        if (nums1.size()> nums2.size()) {
            longest = &nums1;
            shortest = &nums2;
        }
        else {
            longest = &nums2;
            shortest = &nums1;
        }

        int ins = 0;
        for (int el : *shortest) {
            ins = search(*longest, el, ins, longest->size() - 1);
            longest->insert(longest->begin() + ins, el);
        }

        float index = (longest->size() - 1.) / 2;
        if (!isInt(index)) {
            return ((*longest)[(int)index] + (double)(*longest)[(int)index + 1]) / 2;
        }
        else {
            return (*longest)[index];
        }
    }

    static int search(vector<int>& lst, int val, int left, int right) {
        if (lst.empty()) {
            return -1;
        }
        if (right - left <= 1) {
            if (lst[right] < val) {
                return lst.size(); // append to end of vector
            }
            else if(lst[left] > val)
            {
                return 0;  // append to the start of the vector
            }
            else {
                return right; // val should be appended to this index
            }
        }
        int rightOld = right;
        right = (int)std::ceil((left + (double)right) / 2);
        if (lst[right] > val) {
            return search(lst, val, left, right);
        }
        else {
            // return right to what it was
            right = rightOld;
            left = (right + left) / 2;
            
            return search(lst, val, left, right);
        }
    }

    static bool isInt(float num) {
        return num == (int)num;
    }
};