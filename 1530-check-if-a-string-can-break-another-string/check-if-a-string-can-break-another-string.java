class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for(char ch : s1.toCharArray()){
            f1[ch-'a']++;
        }
        for(char ch: s2.toCharArray()){
            f2[ch-'a']++;
        }
        return check(f1,f2) || check(f2,f1);
    }
    public boolean check(int[] f1, int[] f2){
        int diff = 0;
        for(int i = 0;i<26;i++){
            diff+=f1[i];
            if(f2[i] == 0) continue;
            if(diff<f2[i]) return false;
            diff-=f2[i];
        }
        return true;
    }
}