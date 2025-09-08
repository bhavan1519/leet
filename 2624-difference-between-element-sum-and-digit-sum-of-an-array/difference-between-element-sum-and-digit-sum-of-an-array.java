class Solution {
    public int differenceOfSum(int[] nums) {
        int s=0,d=0;
        for(int num:nums){
            s += num;
            while(num != 0){
                int temp = num%10;
                num /= 10;
                d += temp;
            }
        }
        return Math.abs(s-d);
    }
}