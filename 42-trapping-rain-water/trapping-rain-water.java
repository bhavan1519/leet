class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int lMax = height[l];
        int rMax = height[r];
        int w=0;
    while(l < r){
        if(lMax < rMax){
            l++;
            lMax = Math.max(lMax,height[l]);
            w += lMax - height[l];
        }else{
            r--;
            rMax = Math.max(rMax,height[r]);
            w += rMax - height[r];
        }
    }
    return w;
    }
}