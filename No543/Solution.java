package No543;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    private int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int max = depth(root.right) + depth(root.left);
        if (ans < max){
            return max;
        }
        return ans;
    }

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }

        if ((root.left == null && root.right == null)){
            return 1;
        }
        int left = depth(root.left);
        int right = depth(root.right);

        if (left + right > ans){
            ans = left + right;
        }

        return left > right ? left + 1 : right+1;
    }
}
