class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> rooms = new PriorityQueue<>((a,b) -> {
            return a - b;
        });
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            return a.endTime != b.endTime ? a.endTime - b.endTime : a.room - b.room;
        });
        // push all the rooms into rooms min heap
        for(int i =0;i<n;i++){
            rooms.add(i);
        }
        int[] roomCount = new int[n];
        for(int[] meeting : meetings){
            int start = meeting[0];
            int end = meeting[1];
            while(!pq.isEmpty() && start >= pq.peek().endTime){
                Pair p = pq.remove();
                rooms.add(p.room);
            }

            if(!rooms.isEmpty()){
                int room = rooms.remove();
                pq.add(new Pair(end, room));
                roomCount[room]++;
            } else{
                Pair p = pq.remove();
                int endt = p.endTime + (end-start);
                pq.add(new Pair(endt, p.room));
                roomCount[p.room]++;
            }
            
        }
        int maxCount = 0;
        int resultRoom = 0;
        for (int i = 0; i < n; i++) {
            if (roomCount[i] > maxCount) {
                maxCount = roomCount[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}

class Pair{
    int endTime;
    int room;
    Pair(int endTime, int room){
        this.endTime = endTime;
        this.room = room;
    }
}