class Solution {
    int mod = (int)(1e9 + 7);
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n+1];
        dp[1] = 1;
        long people = 0;
        for(int i=2;i<=n;i++){
            long newPeople = 0;
            if(i - delay >= 1)
                newPeople = dp[i-delay];
            long peopleForget = 0;
            if(i-forget >= 1)
            peopleForget = dp[i-forget];

            people = (people + newPeople - peopleForget + mod) % mod;
            dp[i] = people;
        }
        long ans = 0;
        for(int i = n-forget+1;i<=n;i++){
            if(i >= 1) ans=(ans+dp[i])%mod;
        }
        return (int)ans;
    }
}