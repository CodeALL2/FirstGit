package No94;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private ArrayList<Integer> res = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
}

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