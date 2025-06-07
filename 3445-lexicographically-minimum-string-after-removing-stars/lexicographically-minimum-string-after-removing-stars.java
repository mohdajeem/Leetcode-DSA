class Solution {
    public String clearStars(String s) {
        int n = s.length();
        int[] cntArr = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            // return a.ch - b.ch;
            if(a.ch == b.ch){
                return b.ind-a.ind;
            }
            return a.ch - b.ch;
        });
        for(int i =0;i<n;i++){
            char ch1 = s.charAt(i);
            if(ch1 == '*'){
                Pair p = pq.remove();
                char ch = p.ch;
                int ind = p.ind;
                cntArr[i] = -1;
                cntArr[ind]=-1;
            } else{
                pq.add(new Pair(ch1, i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<n;i++){
            if(cntArr[i] != -1){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}

class Pair{
    char ch;
    int ind;
    public Pair(char ch, int ind){
        this.ch = ch;
        this.ind = ind;
    }
}