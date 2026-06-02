/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        order(root,result,0);
        return result;
    }
    public void order(TreeNode root, List<List<Integer>> result, int index){
        if (root == null) {
            return ;
        }
        if(result.size() == index){
            result.add(new ArrayList<>());
        }
        result.get(index).add(root.val);
        order(root.left,result,index+1);
        order(root.right,result,index+1);
    }
}