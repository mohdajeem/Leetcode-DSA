import java.util.regex.*;
class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) return false;
        Pattern digitPat = Pattern.compile("\\d+");
        Matcher digMat = digitPat.matcher(word);
        Pattern charPar = Pattern.compile("\\w{3,}");
        Matcher charParm = charPar.matcher(word);
        Pattern vowelPar = Pattern.compile("[aeiouAEIOU]+");
        Matcher vowelParM = vowelPar.matcher(word);
        Pattern p = Pattern.compile("[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]");
        Matcher pM = p.matcher(word);
        Pattern doll = Pattern.compile("[@#$]+");
        Matcher dollM = doll.matcher(word);
        boolean check = digMat.find() || charParm.find();
        return check && vowelParM.find() && pM.find() && !dollM.find();
    }
}