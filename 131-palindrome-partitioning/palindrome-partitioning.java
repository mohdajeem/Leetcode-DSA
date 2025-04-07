class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        rec(0,s,new ArrayList<>(), ans);
        return ans;
    }
    public void rec(int ind, String s, List<String> list, List<List<String>> ans){
        if(ind == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        // first i will iterate over each element
        for(int i = ind; i< s.length();i++){
            if(isPalindrome(s,ind, i)){
                list.add(s.substring(ind,i+1));
                rec(i+1, s,list,ans);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}