Question: https://leetcode.com/problems/simplify-path/

package Strings.SimplifyPath;

class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("") && !arr[i].equals(".") && !arr[i].equals("..")) {
                st.push(arr[i]);
            } else if (arr[i].equals("..") && !st.empty()) {
                st.pop();
            }
        }
        if (st.empty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String x : st) {
            sb.append("/").append(x);
        }
        return sb.toString();
    }
}