class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left=0,right=0,count=0;
        for(int i=0;i<nums.length;i++){
            int product=1;
            for(int j=i;j<nums.length;j++){
                product*=nums[j];
                if(product>=k){
                    break;
                }
                count++;
            }
        }
        return count;
    }
}