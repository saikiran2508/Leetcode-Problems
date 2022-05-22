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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> tree = new ArrayList<List<Integer>>();
        solve(root, tree, 0);
        Collections.reverse(tree);
        return tree;
    }
    
    public void solve(TreeNode root, List<List<Integer>> tree, int depth){
        if(root == null) return;
        if(tree.size() < depth+1){
            tree.add(new ArrayList<Integer>());
        }
        tree.get(depth).add(root.val);
        solve(root.left, tree, depth+1);
        solve(root.right, tree, depth+1);
    }
}