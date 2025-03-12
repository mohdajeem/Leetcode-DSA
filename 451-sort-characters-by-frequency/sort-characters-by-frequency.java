class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (obj1,obj2)-> {return obj1.fr-obj2.fr;}
        );
        for(char ch : s.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        // freq created now time to sort it
        for(char key : freq.keySet()){
            int val = freq.get(key);
            pq.add(new Pair(key,val));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            for(int i=0;i<p.fr;i++) sb.append(p.c);
        }
        return sb.reverse().toString();
    }
}

class Pair{
    char c;
    int fr;
    public Pair(char c,int fr){
        this.c=c;
        this.fr=fr;
    }

}