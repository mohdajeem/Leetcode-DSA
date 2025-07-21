class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int c = 1;
        sb.append(arr[0]);
        for(int i = 1;i<arr.length;i++){
            if(arr[i] == arr[i-1]){
                c++;
            } else{
                c = 1;
            }
            if(c < 3){
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}