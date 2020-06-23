package com.ryuhi.execute.leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestor {

    private final Map<Integer, TreeNode> map = new HashMap<>(64);

    private final Set<Integer> set = new HashSet<>(64);

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || root == p || root == q) {
            return root;
        }
        recursive(root, p, q);
        while(null != p) {
            set.add(p.val);
            p = map.get(p.val);
        }
        while(null != q) {
            if (set.contains(q.val)) {
                return q;
            }
            q = map.get(q.val);
        }
        return null;
    }

    private void recursive(TreeNode node, TreeNode p, TreeNode q) {
        boolean flag1 = false;
        if (null != node.left) {
            map.put(node.left.val, node);
            if (node.val == p.val) {
                flag1 = true;
            }
            if (!flag1) {
                recursive(node.left, p, q);
            }
        }
        boolean flag2 = false;
        if (null != node.right) {
            map.put(node.right.val, node);
            if (node.val == q.val) {
                flag2 = true;
            }
            if (!flag2) {
                recursive(node.right, p, q);
            }
        }
    }
}
