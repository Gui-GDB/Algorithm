package LeetCode.Main1_100;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树题目
 */
public class Main0100 {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> P = new LinkedList<>();
        Queue<TreeNode> Q = new LinkedList<>();
        P.offer(p);
        Q.offer(q);
        while (!P.isEmpty() && !Q.isEmpty()) {
            TreeNode node = P.poll();
            TreeNode nodeQ = Q.poll();
            if (node != null && nodeQ != null) {
                if (node.val != nodeQ.val) return false;
                P.offer(node.left);
                P.offer(node.right);
                Q.offer(nodeQ.left);
                Q.offer(nodeQ.right);
            } else if (node != nodeQ) return false;
        }
        return P.isEmpty() && Q.isEmpty();
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
