class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        rec(0,s,list,ans);
        return ans;
    }
    public void rec(int ind, String s, List<String> list, List<String> ans){
        if(list.size() == 4){
            if(ind == s.length()) {
                ans.add(String.join(".",list));
            }
            return;
        }
        for(int i = 1;i<4;i++){
            if(ind + i <= s.length()){
                String part = s.substring(ind,ind+i);
                if(isValid(part)){
                    list.add(part);
                    rec(ind+i,s,list, ans);
                    list.remove(list.size()-1);
                }
            }
        }
    }
    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }
}