'''
Given the running logs of n functions that are executed in a nonpreemptive single threaded CPU, find the exclusive time of these functions.

Each function has a unique id, start from 0 to n-1. A function may be called recursively or by another function.

A log is a string has this format : function_id:start_or_end:timestamp. For example, "0:start:0" means function 0 starts from the very beginning of time 0. "0:end:0" means function 0 ends to the very end of time 0.

Exclusive time of a function is defined as the time spent within this function, the time spent by calling other functions should not be considered as this function's exclusive time. You should return the exclusive time of each function sorted by their function id.

Example 1:
Input:
n = 2
logs = 
["0:start:0",
 "1:start:2",
 "1:end:5",
 "0:end:6"]
Output:[3, 4]
'''
class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        
        res= [0]*n
        stack = []
        
        for log in logs:
            lid,ltype,ltime = log.split(':')
            lid = int(lid)
            ltime = int(ltime)
            
            if ltype == 'start':
                if stack:
                    res[stack[-1]] += ltime - prev_time
                stack.append(lid)
                prev_time = ltime
                
            else:
                res[stack.pop()] += ltime +1 - prev_time
                prev_time = ltime +1
                
        return res