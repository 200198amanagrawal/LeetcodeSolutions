Question : https://leetcode.com/problems/subsets-ii/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;
        Stack<List<Integer>> s = new Stack<>();
        List<Integer> empt = new ArrayList<>();
        s.push(empt);
        for (int i = 0; i < n; i++) {
            List<List<Integer>> list = new ArrayList<>();
            while (!s.empty()) {
                List<Integer> x = s.pop();
                List<Integer> y = new ArrayList<>(x);
                list.add(y);
                x.add(nums[i]);
                list.add(x);
            }
            for (List x : list) {
                s.push(x);
            }
        }
        while (!s.empty()) {
            ans.add(s.pop());
        }
        List<List<Integer>> ans1 = new ArrayList<>();
        for (List x : ans) {
            ans1.add(x);
        }
        return ans1;
    }
}