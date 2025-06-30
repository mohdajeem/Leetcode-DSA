class Solution {
    int M = (int)1e9+7;
    public int countTexts(String pressedKeys) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =1;i<=9;i++){
            if(i != 9 && i != 7){
                map.put(i, 3);
            } else{
                map.put(i, 4);
            }
        }
        int n = pressedKeys.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return ways(0,pressedKeys, map, dp);
    }
    public int ways(int ind, String s, Map<Integer,Integer> map, int[] dp){
        if(ind == s.length()){
            return 1;
        }
        if(dp[ind] != -1) return dp[ind];
        int count = 0;
        int maxPress = map.get(s.charAt(ind) - '0');

        for(int i =0;i<maxPress && ind+i < s.length();i++){
            if(s.charAt(ind+i) == s.charAt(ind)){
                count = (count + ways(ind+i+1, s, map, dp))%M;
                // count = count%M;
            } else{
                break;
            }
        }
        return dp[ind]=count;
    }
}