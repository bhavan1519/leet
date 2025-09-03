class Solution {
    public boolean canAliceWin(int[] nums) {
        int sumA=0,sumB=0,tot=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]/10 == 0){
                sumA += nums[i];
            }else{
                sumB += nums[i];
            }
            tot += nums[i];
        }
        int a = tot-sumA;
        int b = tot-sumB;
        if(a==b){
            return false;
        }
        return true;
    }
}