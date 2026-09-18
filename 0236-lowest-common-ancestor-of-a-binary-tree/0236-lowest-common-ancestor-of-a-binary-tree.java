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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> temp1=new ArrayList<>();
        
        List<TreeNode> temp2=new ArrayList<>();
        temp1=helper(root,p);
        temp2=helper(root,q);
        if(temp1.size()==1) return temp1.get(0);
        if(temp2.size()==1) return temp1.get(0);
        for(int i=0;i<Math.min(temp1.size(),temp2.size());i++){
            if(temp1.get(i).val!=temp2.get(i).val){
                return temp1.get(i-1);
            }
        }
        if(temp1.size()<temp2.size()) return temp1.get(temp1.size()-1);
        return temp2.get(temp2.size()-1);
    }
    public List<TreeNode> helper(TreeNode root,TreeNode target){
        List<TreeNode> ans=new ArrayList<>();
        if(root==null) return ans;
        getpath(root,target,ans);
        return ans;
    }
    public boolean getpath(TreeNode root,TreeNode target,List<TreeNode> ans){
        if(root==null) return false;
        ans.add(root);
        if(root.val==target.val) return true;
        if(getpath(root.left,target,ans)|| getpath(root.right,target,ans)) return true;
        ans.remove(ans.size()-1);
        return false;
    }
}