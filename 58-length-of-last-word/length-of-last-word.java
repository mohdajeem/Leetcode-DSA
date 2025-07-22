class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] ans = s.split(" ");
        int res = ans[ans.length-1].length();
        return res;
    }
}