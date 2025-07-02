class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks){
            freq[ch-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int i =0;i<26;i++){
            if(freq[i] > 0){
                pq.add(freq[i]);
            }
        }
        int time = 0;
        while(!pq.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i =1;i<=n+1;i++){
                if(!pq.isEmpty()){
                    int it = pq.remove();
                    it--;
                    list.add(it);
                }
            }
            for(int it : list){
                if(it > 0) pq.add(it);
            }
            time += pq.isEmpty() ? list.size() : n+1;
        }
        return time;
    }
}