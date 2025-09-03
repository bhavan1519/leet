int findNumbers(int* nums, int numsSize) {
    int ans=0;
    for(int i=0;i<numsSize;i++){
        int d=0;
        int x = nums[i];
        while(x>0){
            d++;
            x /= 10;
        }
        if(d%2 == 0) ans++;
    }
    return ans;
}