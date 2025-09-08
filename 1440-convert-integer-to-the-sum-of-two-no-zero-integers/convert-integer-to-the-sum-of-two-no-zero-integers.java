class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<n;i++){
            int l = i;
            int r = n-l;
            if(!String.valueOf(l).contains("0")&&!String.valueOf(r).contains("0"))
            return new int[] {l,r};
        }
        return new int[0];
    }
}