class Solution {
    public int numberOfSubstrings(String s) {
        int[] arr = new int[3];
        int n = s.length(), ans = 0;
        Arrays.fill(arr, -1);
        for(int r = 0;r<n;r++){
            arr[s.charAt(r)-'a'] = r;
            int min = Math.min(arr[0], Math.min(arr[1], arr[2]));
            ans += (min+1);
        }
        return ans;
    }
}