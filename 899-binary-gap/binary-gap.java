class Solution {
    public int binaryGap(int n) {
        int maxDistance = 0;
        int lastPos = -1;
        int index=0;
        while(n>0){
            if((n&1)==1){
                if(lastPos != -1){
                maxDistance = Math.max(maxDistance,index-lastPos);
            }
            lastPos = index;
        }
        n >>= 1;
        index++;
    }
    return maxDistance;
}
}