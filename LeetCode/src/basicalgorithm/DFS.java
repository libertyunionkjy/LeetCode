package basicalgorithm;

import datastructure.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class DFS {

    public static void preorderDFS(BinaryTree tree) {
        Deque<BinaryTree> stack = new LinkedList<>();
        BinaryTree pNode = tree;

        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                System.out.print(pNode.data + ", ");
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop();
                pNode = pNode.right;
            }
        }
    }

    public static void preorderDFS_bk(BinaryTree tree) {
        Deque<BinaryTree> stack = new LinkedList<>();
        stack.push(tree);

        while (!stack.isEmpty()) {
            BinaryTree tmp = stack.pop();
            System.out.println(tmp.data);

            if (tmp.right != null)
                stack.push(tmp.right);
            if (tmp.left != null)
                stack.push(tmp.left);
        }
    }

    public static void inorderDFS(BinaryTree tree) {
        Deque<BinaryTree> stack = new LinkedList<>();
        BinaryTree pNode = tree;

        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop();
                System.out.print(pNode.data + ", ");
                pNode = pNode.right;
            }
        }
    }

    public static void postorderDFS(BinaryTree tree) {
        Deque<BinaryTree> stack = new LinkedList<>();
        Deque<BinaryTree> ostack = new LinkedList<>();
        BinaryTree pNode = tree;

        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                ostack.push(pNode);//根节点最后出栈，最先入栈
                pNode = pNode.right;//右节点倒数第二出栈，后于根节点入栈
            } else {
                pNode = stack.pop();//根节点和右节点都没有了，再进左节点
                pNode = pNode.left;
            }
        }

        while (!ostack.isEmpty()) {
            System.out.print(ostack.pop().data + ", ");
        }
    }

    //递归
    public static void preOrderDFS(BinaryTree tree){
        if(tree == null){
            return;
        }
        System.out.print(tree.data + ", ");
        preOrderDFS(tree.left);
        preOrderDFS(tree.right);
    }
}
