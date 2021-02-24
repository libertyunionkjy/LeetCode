package basicalgorithm;

import datastructure.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void BFS(BinaryTree tree) {
        if(tree == null){
            return;
        }

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(tree);

        while(!queue.isEmpty()){
            BinaryTree pNode = queue.remove();
            System.out.print(pNode.data + ", ");

            if(pNode.left != null)
                queue.add(pNode.left);
            if(pNode.right != null)
                queue.add(pNode.right);
        }
    }
}
