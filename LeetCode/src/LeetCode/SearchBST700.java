package LeetCode;

import datastructure.TreeNode;

public class SearchBST700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        if(root.val == val) return root;
        else if(root.val > val){
            return searchBST(root.left,val);
        }else if(root.val < val){
            return searchBST(root.right,val);
        }
        return null;
    }
}
