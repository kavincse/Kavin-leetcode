 class Solution:
    def maxSubArray(self, b):
        if not b:
            return 0

        curSum = maxSum = b[0]  
        for num in b[1:]:
            curSum = max(num, curSum + num)
            maxSum = max(maxSum, curSum)

        return maxSum
        
        
