class Solution {
    public boolean lemonadeChange(int[] bills) {
        int cnt5=0, cnt10=0;
        for(int i =0;i<bills.length;i++){
            if(bills[i] == 5) cnt5++;
            else if(bills[i]==10){
                cnt5--;
                cnt10++;
            } else{
                if(cnt10 > 0){
                    cnt5--;
                    cnt10--;
                } else{
                    cnt5 -= 3;
                }
            }
            if(cnt5 <0) return false;
        }
        return true;
    }
}