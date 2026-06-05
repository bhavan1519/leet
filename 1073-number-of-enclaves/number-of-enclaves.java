class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][]visited = new boolean[row][col];

        for(int i=0;i<col;i++){
            if(grid[0][i]==1){
                q.offer(new Pair(0,i));
                visited[0][i] = true;
            }
            if(grid[row-1][i]==1){
                q.offer(new Pair(row-1,i));
                visited[row-1][i]=true;
            }
        }

        for(int i=0;i<row;i++){
            if(grid[i][0]==1){
                q.offer(new Pair(i,0));
                visited[i][0]=true;
            }
            if(grid[i][col-1]==1){
                q.offer(new Pair(i,col-1));
                visited[i][col-1]=true;
            }
        }
        int[] drow = {-1,1,0,0};
        int[] dcol = {0,0,1,-1};

        while(!q.isEmpty()){
            Pair current = q.poll();
            int nrow = current.row;
            int ncol = current.col;

            for(int i=0;i<4;i++){
                int ro = nrow+drow[i];
                int co = ncol+dcol[i];

                if(ro>=0 && co>=0 && ro<row && co<col && grid[ro][co]==1 && !visited[ro][co]){
                    visited[ro][co]=true;
                    q.offer(new Pair(ro,co));
                }
            }
        }
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}