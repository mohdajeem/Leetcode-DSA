class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) return false;
        word = word.toLowerCase();
        // System.out.println(word);
        boolean hasVowel = false, hasCons = false;
        for(char ch : word.toCharArray()){
            if(Character.isLetter(ch)){
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                        hasVowel = true;
                } else{
                    hasCons = true;
                }
            } else if(!Character.isDigit(ch)) return false;
        }
        return hasVowel && hasCons;
    }
}