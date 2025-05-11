class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 1;
        for(int i=0;i<arr.length-1;i++){
            while(i<arr.length-1 && arr[i]%2 != 0 && arr[i+1]%2 != 0 && (arr[i] == arr[i] || arr[i] == arr[i+1])){
                count++;
                i++;
            }
            if(count < 3){
                count =1;
            } else{
                return true;
            }
        }
        return false;
    }
}