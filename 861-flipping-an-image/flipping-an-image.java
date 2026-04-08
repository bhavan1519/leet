class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int r=image.length;
        int c=image[0].length;
        int[][] arr=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
               arr[i][j]=image[i][c-j-1];
               if(arr[i][j]==1){
                arr[i][j]=0;
               } 
               else{
                arr[i][j]=1;
               }
            }
        }
        return arr;
    }
}