package LeetCode;

import datastructure.TreeNode;

public class InsertIntoBST701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        if(root.val > val && root.left == null){
            root.left = new TreeNode(val);
        }else if(root.val < val && root.right == null){
            root.right = new TreeNode(val);
        }else if(root.val > val){
            insertIntoBST(root.left,val);
        }else if(root.val < val){
            insertIntoBST(root.right,val);
        }
        return root;
    }
}
