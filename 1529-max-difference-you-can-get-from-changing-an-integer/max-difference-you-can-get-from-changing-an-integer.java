class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        char maxV = s.charAt(0);
        for(char ch : s.toCharArray()){
            if(ch != '9') {
                maxV = ch;
                break;
            }
        }
        String s2 = s.replace(maxV,'9');
        char minV = s.charAt(0);
        int i =0;
        String s1 = s;
        while(i < s.length()){
            if(i==0 && s.charAt(i) != '1' && s.charAt(i) != '0') {
                s1 = s1.replace(s.charAt(i),'1');
                break;
            } else if(i != 0 && s.charAt(i) != s.charAt(0) && s.charAt(i) != '0'){
                s1 = s1.replace(s.charAt(i),'0');
                break;
            }
            i++;
        }
        System.out.println(s2 + " "+ s1);
        return Integer.parseInt(s2)-Integer.parseInt(s1);
    }
}