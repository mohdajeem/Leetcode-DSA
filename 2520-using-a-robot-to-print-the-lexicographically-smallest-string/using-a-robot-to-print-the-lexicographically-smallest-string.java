class Solution {
    public String robotWithString(String s) {
        // preprocess smallest char in its right side
        int n = s.length();
        char[] minCharToRight = new char[n];
        // Stack<Character> st = new Stack<>();
        minCharToRight[n-1]=s.charAt(n-1);
        for(int i =n-2;i>=0;i--){
            if(s.charAt(i)>minCharToRight[i+1]){
                // System.out.println("inside "+minCharToRight[i+1]);
                minCharToRight[i]=minCharToRight[i+1];
            } else{
                minCharToRight[i] = s.charAt(i);
            }
        }
        System.out.println(Arrays.toString(minCharToRight));
        Stack<Character> st = new Stack<>();
        int i =0;
        StringBuilder sb = new StringBuilder();
        while(i<n){
            char ch = s.charAt(i);
            st.push(ch);
            char minChar = (i+1<n) ? minCharToRight[i+1] : ch;
            while(!st.isEmpty() && st.peek() <= minChar){
                sb.append(st.pop());
            }
            i++;
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }
}