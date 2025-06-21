class Solution {
    public int minimumDeletions(String word, int k) {
        int[] chArr = new int[26];
        for(char ch : word.toCharArray()){
            chArr[ch-'a']++;
        }

        int min = Integer.MAX_VALUE;
        for(int i =0;i<26;i++){
            int sum = 0;
            int x = chArr[i];
            for(int j = 0;j<26;j++){
                int y = chArr[j];
                if(y<x) sum+=y;
                else if(y>x+k) sum += (y-x-k);
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}