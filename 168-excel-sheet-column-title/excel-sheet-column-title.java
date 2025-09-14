class Solution {
    public String convertToTitle(int columnNumber) {
        String s = "";
        while(columnNumber > 0){
            columnNumber -= 1;
            int temp = columnNumber % 26;
            s = (char)(65+temp)+s;
            columnNumber /= 26;
        }
        return s;
    }
}