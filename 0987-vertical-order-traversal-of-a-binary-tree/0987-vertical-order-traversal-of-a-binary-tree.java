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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int minlevel = Integer.MAX_VALUE , maxlevel = Integer.MIN_VALUE;
        //PriorityQueue<Pair> q = new PriorityQueue<>((a,b)-> a.row==b.row ? a.col - b.col  : a.row - b.row);
        Queue<Pair> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        q.add(new Pair(root, 0, 0));

        while(!q.isEmpty()){
            Pair top = q.poll();
            addToMap(top, map);
            minlevel = Integer.min(minlevel, top.col);
            maxlevel = Integer.max(maxlevel, top.col);
            if(top.node.left != null){ q.add( new Pair(top.node.left, top.row + 1, top.col - 1));}
            if(top.node.right != null){ q.add( new Pair(top.node.right, top.row + 1, top.col + 1));}
        }

        for(int i = minlevel ; i <= maxlevel; i++){
            List<Pair> list = map.get(i);
            Collections.sort(list, (a,b)-> a.col==b.col && a.row==b.row ? a.node.val - b.node.val  : a.row - b.row);
            List<Integer> res = new ArrayList<Integer>();
            for(Pair p : list){
                res.add(p.node.val);
            }
            ans.add(res);
        }
        
        return ans;
    }

    private void addToMap(Pair top, HashMap<Integer, List<Pair>> map){
       map.computeIfAbsent(top.col, k -> new ArrayList<>()).add(top);
    }
}

class Pair{
    TreeNode node;
    int row;
    int col;
    Pair(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}