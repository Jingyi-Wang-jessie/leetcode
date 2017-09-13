'''
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
'''

class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """ 
        
        res = [0]*(len(num1)+len(num2))
        pos = len(res) -1
        
        for n1 in reversed(num1):
            tempPos = pos
            for n2 in reversed(num2):
                res[tempPos] += int(n1) * int(n2)
                res[tempPos-1] += res[tempPos] / 10
                res[tempPos] = res[tempPos] % 10
                tempPos -= 1
            pos -=1
            
        pt = 0
        while pt < len(res) and res[pt] ==0:
            pt +=1
            
        if pt == len(res):
            return "0"
        else:    
            return ''.join(map(str,res[pt:]))