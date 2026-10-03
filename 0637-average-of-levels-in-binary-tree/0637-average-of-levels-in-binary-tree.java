/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> avg=new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        bfs(root);
        return avg;
    }
    public void bfs(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> nodes=new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()){
            int n=nodes.size();double sum=0;
            for(int i=0;i<n;i++){
                TreeNode curr=nodes.poll();
                sum+=(double)(curr.val);
                if(curr.left!=null) nodes.offer(curr.left);
                if(curr.right!=null) nodes.offer(curr.right);
            }
            avg.add(sum/(double)n);
        }
        return;
    }
}