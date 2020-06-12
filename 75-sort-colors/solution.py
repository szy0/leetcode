class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        p1 = 0
        p2 = len(nums) - 1
        index = 0

        while (index < p2):
            if (nums[index] == 0):
                nums[index] = nums[p1]
                nums[p1] = 0
                p1 += 1

            if (nums[index] == 2):
                nums[index] = nums[p2]
                nums[p2] = 2
                p2 -= 1
                index -= 1

            index += 1
