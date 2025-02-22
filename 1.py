class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        pairs = {}
        for i, num in enumerate(nums):
            if num in pairs:
                return pairs[num], i
            else:
                pairs[target - num] = i
        