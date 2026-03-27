class Solution {
    public int subtractProductAndSum(int n) {
    int p=1,s=0,r;
    while(n>0){
        int res=n%10;
        p=p*res;
        s=s+res;
        n=n/10;
    }
    r = p-s;
    return r;
    }
}