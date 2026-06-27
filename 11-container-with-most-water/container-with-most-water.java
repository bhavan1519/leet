class Solution {
    public int maxArea(int[] height) {
        int h = height.length;
        int i = 0;
        int j = h-1;
        int res=0;
         while (i < j) {
            res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return res;
    }
}