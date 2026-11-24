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
    Map<Integer, Integer> hm = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        sum(root);
        int max = 0;
        
        for(int v : hm.values()) {
            max = Math.max(max, v); 
        }

        List<Integer> ans = new ArrayList<>();

        for(int k : hm.keySet()) {
            if(hm.get(k) == max) ans.add(k);
        }

        int[] arr = new int[ans.size()];

        for(int i=0; i<ans.size(); i++) {
            arr[i] = ans.get(i);
        }

        return arr;
    }

    private int sum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int l = sum(root.left);
        int r = sum(root.right);
        int curr = l+r+root.val;

        hm.put(curr, hm.getOrDefault(curr, 0)+1);

        return curr;
    }
}