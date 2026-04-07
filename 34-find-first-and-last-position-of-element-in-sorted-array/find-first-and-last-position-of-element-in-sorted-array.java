class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target);
        int last = upperBound(nums, target) - 1;
        if(first == nums.length || nums[first] != target){
            return new int[]{-1, -1};
        }
        return new int[]{first, last};
    }
    public int lowerBound(int[] arr, int target){
        int low = 0, high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] >= target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public int upperBound(int[] arr, int target){
        int low = 0, high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}