class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int c =0;
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(baskets[j] != -1 && fruits[i] <= baskets[j]){
                    c++;
                    baskets[j]=-1;
                    break;
                }
            }
        }
        return n-c;
    }
}