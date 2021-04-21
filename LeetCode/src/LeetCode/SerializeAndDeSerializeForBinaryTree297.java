package LeetCode;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeSerializeForBinaryTree297 {


    /**
     * 二叉树的前序遍历进行序列化和反序列化
     */
    // Encodes a tree to a single string.
    String NULL = "#";
    String SPLIT = ",";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorderSerialize(root, sb);
        return sb.toString();
    }

    void preorderSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SPLIT);
            return;
        }

        sb.append(root.val).append(SPLIT);
        preorderSerialize(root.left, sb);
        preorderSerialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        for (String s : data.split(SPLIT)) {
            list.addLast(s);
        }
        return preorderDeserialize(list);
    }

    //my method
    TreeNode preorderDeserialize(String[] arr, int start, int end) {
        if (arr[start].equals(NULL))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[start]));
        int leftEnd = start + 1;
        int count = 1;
        do {
            if (arr[leftEnd].equals(NULL)) {
                leftEnd++;
                count--;
            } else {
                leftEnd++;
                count++;
            }
        } while (count > 0);
        root.left = preorderDeserialize(arr, start + 1, leftEnd);
        root.right = preorderDeserialize(arr, leftEnd, end);
        return root;
    }

    //labuladong method
    TreeNode preorderDeserialize(LinkedList<String> list) {
        if (list.isEmpty())
            return null;
        String s = list.removeFirst();
        if (s.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = preorderDeserialize(list);
        root.right = preorderDeserialize(list);

        return root;
    }

    /**
     * 后序遍历和前序遍历相似，中序遍历无法完成反序列化
     */
    /**
     * 看一下层序遍历的序列化和反序列化
     */
    void BFSSerialize(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp == null) {
                sb.append(NULL).append(SPLIT);
                continue;
            }

            sb.append(tmp.val).append(SPLIT);
            queue.offer(tmp.left);
            queue.offer(tmp.right);
        }
    }
}
