//Memorization
class Solution{
    public int climbStairs(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return climb(dp,n);
    }
    public int climb(int[] dp,int n){
        if(n<=2){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = climb(dp,n-1)+climb(dp,n-2);
        return dp[n];
    }
}

//Tabulation
/*class Solution{
    public int climbStairs(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        if(n<=2){
            return n;
        }
        dp[1]=1;
        dp[0]=0;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}*/
