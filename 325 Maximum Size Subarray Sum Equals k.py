#Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
class Solution(object):
    def maxSubArrayLen(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        
        res,acc = 0,0
        acc_index_map = {0:-1}
        
        for i in xrange(len(nums)):
            acc += nums[i]
            if not acc_index_map.has_key(acc):
                acc_index_map[acc] = i
            if acc_index_map.has_key(acc-k):
                res = max(res, i - acc_index_map[acc-k])
                
        return res