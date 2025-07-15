class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) return false;
        String vowels = "aeiouAEIOU";
        String cons = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYX";
        String ext = "@#$";
        String num = "0123456789";
        int vow = 0, consC = 0, numC = 0;
        for(char ch : word.toCharArray()){
            if(vowels.contains(String.valueOf(ch))){
                vow++;
            }
            if(cons.contains(String.valueOf(ch))){
                consC++;
            }
            if(num.contains(String.valueOf(ch))){
                numC++;
            }
            if(ext.contains(String.valueOf(ch))) return false;
        }

        return vow>0 && consC>0;

    }
}