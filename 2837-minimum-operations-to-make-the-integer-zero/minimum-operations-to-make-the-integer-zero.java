class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int ops=1;ops <= 60;ops++){
            long target = (long)num1 - (long) ops * num2;
            if(target < ops) continue;
            int bitCount = Long.bitCount(target);
            if(bitCount <= ops){
                return ops;
            }
        }
        return -1;
    }
}