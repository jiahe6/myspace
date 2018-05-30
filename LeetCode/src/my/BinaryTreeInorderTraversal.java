package my;


import java.util.ArrayList;
import java.util.Stack;

/**
 * For example: Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */

public class BinaryTreeInorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (root == null)
			return ret;
		
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.add(root);
		
		TreeNode p = root.left;
		while(! st.isEmpty()) {
			while (p != null) {
				st.add(p);
				p = p.left;
			}
			TreeNode node = st.pop();
			ret.add(node.val);
			
			p = node.right;
			if (p != null) {
				st.add(p);
				p = p.left;
			}
		}
		
		return ret;
	}
}