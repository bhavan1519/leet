class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(0, target, candidates, curr, ans);
        return ans;
    }

    private void solve(int index, int target, int[] arr, List<Integer> curr, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (index == arr.length) {
            return;
        }

        if (arr[index] <= target) {
            curr.add(arr[index]);
            solve(index, target - arr[index], arr, curr, ans);
            curr.remove(curr.size() - 1);
        }
        solve(index + 1, target, arr, curr, ans);
    }
}