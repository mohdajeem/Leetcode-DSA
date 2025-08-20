class Solution {
    public int maxLength(List<String> arr) {
        Map<String, Integer> dp = new HashMap<>();
        return rec(0,"",arr, dp);
    }
    public int rec(int ind, String s, List<String> arr, Map<String, Integer> dp){
        if(ind >= arr.size()){
            return s.length();
        }
        if(dp.containsKey(s)) return dp.get(s);
        String str = arr.get(ind);
        int notTake = 0;
        int take = 0;
        if(hasUnique(str,s)){
            take = rec(ind+1,s + str, arr,dp);
            notTake = rec(ind+1, s, arr, dp);
        } else{
            notTake = rec(ind+1, s,arr,dp);
        }

        int res = Math.max(take, notTake);
        dp.put(s,res);
        return res;

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

}