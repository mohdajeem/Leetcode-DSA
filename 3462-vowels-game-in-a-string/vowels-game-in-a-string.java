class Solution {
    public boolean doesAliceWin(String s) {
        int cntVowel = 0;
        for(char ch : s.toCharArray()){
            if(isVowel(ch)) cntVowel++;
        }
        if(cntVowel == 0) return false;
        return true;
    }
    public boolean isVowel(char ch){
        return ch == 'a' || ch=='e' || ch == 'i' || ch=='o' || ch=='u';
    }
}