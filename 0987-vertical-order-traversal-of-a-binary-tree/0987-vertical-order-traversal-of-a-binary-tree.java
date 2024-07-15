/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        {
            int minL = Integer.MAX_VALUE, maxL = Integer.MIN_VALUE;
            int row = 0;
            Map<Integer, List<Pair>> map = new HashMap<>();
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(root, row, 0));

            while (!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    Pair top = queue.poll();
                    minL = Integer.min(minL, top.col);
                    maxL = Integer.max(maxL, top.col);

                    map.putIfAbsent(top.col, new ArrayList<>());
                    map.get(top.col).add(top);

                    if (top.node.left != null) {
                        queue.add(new Pair(top.node.left, top.row + 1, top.col - 1));
                    }
                    if (top.node.right != null) {
                        queue.add(new Pair(top.node.right, top.row + 1, top.col + 1));
                    }
                }
            }

            List<List<Integer>> result = new ArrayList<>();
            while (minL <= maxL) {
                List<Pair> list = map.get(minL);
                Collections.sort(list, (a,b)-> a.col==b.col && a.row==b.row ? a.node.val - b.node.val  : a.row - b.row);
                result.add(list.stream().map(p -> p.node.val).collect(Collectors.toList()));
                minL++;
            }

            return result;
        }
    }
}
class Pair{
    TreeNode node;
    int row;
    int col;
    
    public Pair(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}