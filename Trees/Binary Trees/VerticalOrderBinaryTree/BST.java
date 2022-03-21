Question : https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

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
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(0, 0, root));
        List<Pair> list = new ArrayList<>();
        while (!st.empty()) {
            Pair p = st.pop();
            list.add(p);
            TreeNode node = p.node;
            if (node.left != null) {
                st.push(new Pair(p.x + 1, p.y - 1, node.left));
            }
            if (node.right != null) {
                st.push(new Pair(p.x + 1, p.y + 1, node.right));
            }
        }
        Collections.sort(list, new PairComparator());
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        newList.add(list.get(0).node.val);
        for (int i = 1; i < list.size(); i++) {
            Pair p = list.get(i);
            Pair p0 = list.get(i - 1);
            if (p.y == p0.y) {
                newList.add(p.node.val);
            } else {
                ans.add(newList);
                newList = new ArrayList<>();
                newList.add(p.node.val);
            }
        }
        ans.add(newList);
        return ans;
    }

    public class Pair {
        int x;
        int y;
        TreeNode node;

        Pair(int x1, int y1, TreeNode node1) {
            x = x1;
            y = y1;
            node = node1;
        }
    }

    public class PairComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            if (p1.y < p2.y) {
                return -1;
            } else if (p1.y > p2.y) {
                return 1;
            }
            if (p1.x < p2.x) {
                return -1;
            } else if (p1.x > p2.x) {
                return 1;
            }
            if (p1.node.val < p2.node.val) {
                return -1;
            }
            return 1;
        }
    }
}