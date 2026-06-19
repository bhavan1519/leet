class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int highest = 0;
        for (int i=0; i<=n; i++) {
            int alt = 0;
            for (int j=0; j<i; j++) {
                alt += gain[j];
            }
            highest = Math.max(highest, alt);
        }
        return highest;
    }
}