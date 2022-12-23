class Solution {
    public int removeElement(int[] nums, int val) {
        for(int tail = 0, head = 0; ; tail++)
            if(tail == nums.length) return head;
            else if(nums[tail] != val) nums[head++] = nums[tail];
    }
}
