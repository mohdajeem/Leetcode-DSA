class Solution {
    public String largestGoodInteger(String num) {
        String[] str = {"999", "888","777","666","555","444","333","222","111","000"};
        for(String s : str){
            if(num.contains(s)){
                return s;
            }
        }
        return "";
    }
}