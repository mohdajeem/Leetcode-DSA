class Solution {
    public boolean divisorGame(int n) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        return memo(n, map);
    }
    public boolean memo(int n, HashMap<Integer, Boolean> map){
        // momoize 
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n == 1) return false;
        List<Integer> factors = new ArrayList<>();
        factors.add(1);
        for(int i=2;i*i<=n;i++){
            if(n %i == 0){
                factors.add(i);
                if(i != (n/i)){
                    factors.add(n/i);
                }
            }
        }
        for(int f : factors){
            if(!memo(n-f, map)){
                map.put(n, true);
                return true;
            }
        }
        map.put(n, false);
        return false;
    }
}