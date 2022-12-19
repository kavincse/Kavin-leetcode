class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }
    
    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int ans = 0; 
        ans += mergeSort(nums, start, mid);
        ans += mergeSort(nums, mid + 1, end);
        ans += merge(nums, start, mid, end);
        return ans;
    }
    
    private int merge(int[] nums, int start, int mid, int end) {
        int i = start; 
        int j = mid + 1;
        int count = 0;
        while (i <= mid && j <= end) {
            if ((long) nums[i] > 2 * (long) nums[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }            
        }
        int[] temp = new int[end - start + 1];
        int idx = 0;
        i = start; 
        j = mid + 1;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[idx++] = nums[i++];
            } else {
                temp[idx++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[idx++] = nums[i++];
        }
        while (j <= end) {
            temp[idx++] = nums[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            nums[k + start] = temp[k];
        }
        return count;
    }
}
