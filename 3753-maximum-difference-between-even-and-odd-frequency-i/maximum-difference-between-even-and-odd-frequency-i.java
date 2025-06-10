class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char ch : s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch,0)+1);
        }
        int maxOdd = Integer.MIN_VALUE, minEven = Integer.MAX_VALUE;
        for(char key : freq.keySet()){
            if(freq.get(key)%2==0){
                minEven = Math.min(freq.get(key), minEven);
            } else{
                maxOdd = Math.max(freq.get(key), maxOdd);
            }
        }
        return maxOdd - minEven;
    }
}