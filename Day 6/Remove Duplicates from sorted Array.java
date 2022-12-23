class Solution {
    public int removeDuplicates(int[] nums) {
        int Index = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] != nums[i]) {
                nums[Index] = nums[i];     
                Index++;
            }
        }
        return Index;
    }
}
