class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return solve(head, null);
    }
    public TreeNode solve(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head == tail) return null;
        while(fast!=tail && fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = solve(head, slow);
        root.right = solve(slow.next, tail);
        return root;
    }
}