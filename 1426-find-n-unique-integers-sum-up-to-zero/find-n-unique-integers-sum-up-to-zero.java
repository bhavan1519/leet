class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        result[0] = n*(1-n)/2;
        for(int i=1;i<n;++i){
            result[i] = i;
        }
        return result;
    }
}