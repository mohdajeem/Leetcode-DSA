class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<tasks.length;i++){
            map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((obj1, obj2) -> {
            return obj2-obj1;
        });
        for(char key : map.keySet()){
            pq.add(map.get(key));
        }
        int time = 0;
        while(!pq.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i = 1;i<=n+1;i++){
                if(!pq.isEmpty()){
                    int it = pq.remove();
                    it--;
                    list.add(it);
                }
            }
            for(int it : list){
                if(it > 0){
                    pq.add(it);
                }
            }
            time += pq.isEmpty() ? list.size() : (n+1);
        }
        return time;
    }
}