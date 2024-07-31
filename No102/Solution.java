package No102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
    private TreeNode lock = new TreeNode();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        queue.offer(lock);

        boolean flag = true;
        List<Integer> tmp = null;
        while (!queue.isEmpty()){
            if (flag){
                tmp = new ArrayList<>();
                flag = false;
            }

            TreeNode node = queue.poll();
            if (node == lock){
                res.add(tmp);
                if (queue.isEmpty()){
                    break;
                }
                queue.offer(lock);
                flag = true;
            }else {
                tmp.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
