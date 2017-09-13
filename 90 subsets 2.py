'''
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.
'''

class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        
        nums = sorted(nums)
        res = [[]]
        for i in range(0,len(nums)):
            if i==0 or nums[i]!= nums[i-1]:
                left = len(res)
            for j in range(len(res) - left, len(res)):
                res.append(res[j] + [nums[i]])
            
        return res