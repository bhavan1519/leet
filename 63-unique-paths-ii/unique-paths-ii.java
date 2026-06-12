class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    continue;
                }
                if(obstacleGrid[i][j]==1){
                    dp[i][j] =0;
                    continue;
                }
                int left=0,up=0;
                if(i>0){
                    up = dp[i-1][j];
                }
                if(j>0){
                    left = dp[i][j-1];
                }
                dp[i][j] = left+up;
            }
        }
        return dp[m-1][n-1];
    }
}