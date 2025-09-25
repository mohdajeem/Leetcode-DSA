class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        rec(0, s, new ArrayList<>(), result);
        return result;
    }
    public void rec(int i, String s, List<String> list, List<List<String>> result){
        if(i == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        
        for(int j = i;j<s.length();j++){
            if(isPalindrome(s, i, j)){
                list.add(s.substring(i,j+1));
                rec(j+1, s, list, result);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}