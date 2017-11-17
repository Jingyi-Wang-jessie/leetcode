/*
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int min, max = 0;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null){
            return list; 
        }
        
        computeLength(root, 0);
        
        int num = max - min +1;
        
        for (int i =0; i< num; i++){
            list.add(new ArrayList<Integer>());
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> idx = new LinkedList<Integer>();
        
        q.add(root);
        idx.add(-min);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            int pos = idx.poll();
            
            list.get(pos).add(node.val);
            
            if(node.left != null){
                q.add(node.left);
                idx.add(pos-1);
            }
            
            if(node.right != null){
                q.add(node.right);
                idx.add(pos+1);
            }
        }
        
        return list;
    }
    
    private void computeLength(TreeNode root, int i){
        if (root == null){
            return;
        }
        min = Math.min(min, i);
        max = Math.max(max, i);
        computeLength(root.left, i-1);
        computeLength(root.right, i+1);
    }
}

/*
首先计算整个数组的range, 也就是最左和最右的值，运用dfs. 然后用队列，依次把对应的node放进结果中，第二次dfs.
*/