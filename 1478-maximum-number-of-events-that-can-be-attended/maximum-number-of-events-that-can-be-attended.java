class Solution {
    public int maxEvents(int[][] events) {
        int max = 0;
        for(int i =0;i<events.length;i++){
            max = Math.max(max, events[i][1]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(a,b));
        Arrays.sort(events, (a,b) -> a[0]-b[0]);
        int ans = 0, j =0;
        for(int i =1;i<=max;i++){
            while(j<events.length && events[j][0] <= i){
                pq.add(events[j][1]);
                j++;
            }
            while(!pq.isEmpty() && pq.peek() < i){
                pq.remove();
            }
            if(!pq.isEmpty()){
                ans++;
                pq.remove();
            }
        }
        return ans;
    }
}