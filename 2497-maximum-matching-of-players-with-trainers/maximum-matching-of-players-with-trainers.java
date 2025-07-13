class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        
        int n = players.length, m = trainers.length, c=0;
        int i = 0, j = 0;
        while(i<n && j < m){
            if(players[i] <= trainers[j]){
                i++;
                j++;
                c++;
            } else{
                j++;
            }
        }
        return c;
        // int s = 0, e = Math.min(n, m);
        // while(s <= e){
        //     int mid = s + (e-s)/2;
        //     if(isPossible()){
        //         s = mid+1;
        //     } else{
        //         e = mid-1;
        //     }
        // }
        // return e;
    }
}