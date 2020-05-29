class Solution:
    def countBits(self, num: int) -> List[int]:
        i = 1
        res = [0]
        while i <= num:
            res.append(res[i >> 1] + (i & 1))
            i += 1
        return res