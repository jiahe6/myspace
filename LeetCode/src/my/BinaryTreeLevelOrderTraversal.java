package my;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        
        if (root == null) {
        	return list;
        }
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        currentLevel.add(root);
        
        while(!currentLevel.isEmpty()) {
            
            List<Integer> currentList = new ArrayList<Integer>();
            
            int size = currentLevel.size();
            
            for (int i =0;i < size;i++) {
            	TreeNode tn = currentLevel.poll();
                currentList.add(tn.val);
                
                if (tn.left != null) {
                	currentLevel.add(tn.left);
                }
                if (tn.right != null) {
                	currentLevel.add(tn.right);
                }
            }
            
            list.add(currentList);
            
        }
        
        return list;
        
    }
}
