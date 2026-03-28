class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] arr = new int[nums.length];
        int pos=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                arr[pos] = nums[i];
                pos = pos+2;
            }
        }
        int neg=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                arr[neg] = nums[i];
                neg = neg+2;
            }
        }
        return arr;
    }
}