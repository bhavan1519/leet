class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        flip = False
        while n>1:
            mid = 1<<(n-1)
            length = (1<<n)-1
            if k==mid:
                return '0' if flip else '1'
            if k>mid:
                k = length-k+1
                flip = not flip
            n-=1
        return '1' if flip else '0'