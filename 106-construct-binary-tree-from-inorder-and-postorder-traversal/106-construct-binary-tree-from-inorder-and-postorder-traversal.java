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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Arrays.reverse(postorder);
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        Map<Integer, Integer> mp = new HashMap<>();
        int n = inorder.length;
        for(int i = 0; i < n; i++){
            mp.put(inorder[i], i);
        }
        TreeNode root = build(inorder, 0, n-1, postorder, 0, n-1, mp);
        return root;
    }
    public TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> mp){
        if(ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int inRoot = mp.get(postorder[pe]);
        int numsLeft = inRoot - is;
        root.left = build(inorder, is, inRoot-1, postorder, ps, ps + numsLeft - 1, mp);
        root.right = build(inorder, inRoot+1, ie, postorder, ps+numsLeft, pe-1, mp);
        return root;
    }
}