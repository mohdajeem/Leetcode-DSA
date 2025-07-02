class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            return Integer.compare(b.count, a.count);
        });
        for(int i =0;i<26;i++){
            if(freq[i] != 0){
                pq.add(new Pair((char)(i+'a'), freq[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p1 = pq.remove();
            int freq1 = p1.count;
            char ch1 = p1.ch;
            if(!pq.isEmpty()){
                Pair p2 = pq.remove();
                int freq2 = p2.count;
                char ch2 = p2.ch;
                sb.append(ch1);
                freq1--;
                sb.append(ch2);
                freq2--;
                if(freq1 != 0) pq.add(new Pair(ch1,freq1));
                if(freq2 != 0) pq.add(new Pair(ch2,freq2));
            }
            else{
                if(freq1 > 1){
                    return "";
                } else{
                    sb.append(ch1);
                }
            }
        }
        return sb.toString();
    }
}
class Pair{
    char ch;
    int count;
    public Pair(char ch, int count){
        this.ch = ch;
        this.count = count;
    }
}