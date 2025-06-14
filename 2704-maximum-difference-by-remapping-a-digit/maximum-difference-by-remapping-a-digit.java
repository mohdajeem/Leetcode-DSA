class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char ch = s.charAt(0);
        int maxi =  (ch != '9') ? Integer.parseInt(s.replace(ch,'9')) : Integer.parseInt(s.replace(solve(s),'9'));
        int mini = Integer.parseInt(s.replace(ch,'0'));
        
        return maxi - mini;
    }
    public char solve(String s){
        for(char ch : s.toCharArray()){
            if(ch != '9') return ch;
        }
        return '9';
    }
}