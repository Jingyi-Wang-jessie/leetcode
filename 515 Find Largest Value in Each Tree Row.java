/*
You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
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
    private int depth = 1;
    public List<Integer> largestValues(TreeNode root) {
        if (root == null){
            return new ArrayList<Integer>();
        }
        List<List<Integer>> rows = new ArrayList<>();
        
        computeDepth(root,1);
        
        for (int i=0;i<depth;i++){
            rows.add(new ArrayList<Integer>());
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> lev = new LinkedList<Integer>();
        
        q.add(root);
        lev.add(0);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            int idx = lev.poll();
            
            rows.get(idx).add(node.val);
            
            if(node.left !=null){
                q.add(node.left);
                lev.add(idx+1);
            }
            if(node.right !=null){
                q.add(node.right);
                lev.add(idx+1);
            }
        }
        
        List<Integer> maxInRow = new ArrayList<Integer>();
        for (int i =0;i<depth;i++){
            maxInRow.add(Collections.max(rows.get(i)));
        }
        
        return maxInRow;
    }
    
    private void computeDepth(TreeNode root, int level){
        if(root.left == null){
            depth = Math.max(depth, level);
        }else{
            computeDepth(root.left, level+1);
        }
        
        if(root.right == null){
            depth = Math.max(depth, level);
        }else{
            computeDepth(root.right, level+1);
        }
    }
}

public class Solution1 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }
       //expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
        //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }
}

/*
其实只需要一次dfs，就可以。
*/