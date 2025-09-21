class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            return b.freq - a.freq;
        });
        for(Map.Entry<Character,Integer> it : map.entrySet()){
            pq.add(new Pair(it.getKey(), it.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            for(int i =0;i<p.freq;i++){
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }
}
class Pair{
    char ch;
    int freq;
    Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}