class Solution {
    public int maxLength(List<String> arr) {
        Map<String, Integer> dp = new HashMap<>();
        return rec(0, arr, "", dp);
    }
    public boolean hasUnique(String s1, String s2){
        int[] arr = new int[26];
        for(char ch : s1.toCharArray()){
            if(arr[ch-'a'] >0) return false;
            arr[ch-'a']++;
        }
        for(char ch : s2.toCharArray()){
            if(arr[ch-'a']>0) return false;
        }
        return true;
    }
    public int rec(int ind, List<String> arr, String temp, Map<String, Integer> dp){
        if(ind >= arr.size()) return temp.length();
        if(dp.containsKey(temp)) return dp.get(temp);
        String s = arr.get(ind);
        int exc = 0, inc =0;
        if(hasUnique(s, temp)){
            exc = rec(ind+1, arr, temp, dp);
            inc = rec(ind+1, arr, temp+s, dp);
        } else{
            exc = rec(ind+1,arr, temp, dp);
        }

        int res = Math.max(exc, inc);
        dp.put(temp, res);
        return dp.get(temp);
    }
}