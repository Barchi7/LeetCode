class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            // If the middle element is the target, return its index
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check which half of the array is sorted and perform binary search accordingly
            if (nums[start] <= nums[mid]) { // Left half is sorted
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // Right half is sorted
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        
        // If target is not found, return -1
        return -1;
    }
}
