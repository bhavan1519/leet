class Solution {
    int n;
    List<List<Integer>> Ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {    
         List<Integer> op = new ArrayList<>();
         n = nums.length;
          backtrack(op,nums,0);
          return Ans;

    }
    public void backtrack(List<Integer> op, int[] nums , int startIndex){
        if(startIndex == n){
            Ans.add(new ArrayList<>(op));
            return;
        }
        op.add(nums[startIndex]);
        backtrack(op,nums,startIndex+1);
        op.remove(op.size()-1);
        backtrack(op,nums,startIndex+1);
    }
}