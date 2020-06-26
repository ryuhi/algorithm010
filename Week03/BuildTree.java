import java.util.*;
import java.util.stream.Collectors;

public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || null == inorder) {
            return null;
        }
        int insize = inorder.length;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        List<Integer> inList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        int rootIndex = inList.indexOf(rootVal);
        int[] pre_left = Arrays.copyOfRange(preorder,1,rootIndex+1);
        int[] pre_right = Arrays.copyOfRange(preorder,rootIndex+1,preorder.length);
        int[] in_left = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] in_right = Arrays.copyOfRange(inorder, rootIndex + 1, insize);
        root.left = buildTree(pre_left, in_left);
        root.right = buildTree(pre_right, in_right);
        return root;
    }
}
