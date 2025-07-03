class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        while(sb.length() < k){
            StringBuilder sb2 = new StringBuilder();
            for(int i =0;i<sb.length();i++){
                char ch = sb.charAt(i);
                sb2.append((char)(ch+1));
            }
            sb.append(sb2);
        }
        return sb.charAt(k-1);

    }
}