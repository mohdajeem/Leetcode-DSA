class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        int n = digits.length;
        for(int i=0;i<n;i++){
            freq[digits[i]]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int m = 100;m<999;m+=2){
            if(canAns(m, freq)){
                ans.add(m);
            }
        }
        Collections.sort(ans);
        int[] res = new int[ans.size()];
        for(int i =0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;

    }
    public boolean canAns(int n, int[] freq){
        int[] newF = Arrays.copyOf(freq, freq.length);
        while(n!=0){
            int dig = n%10;
            newF[dig]--;
            if(newF[dig]<0){
                return false;
            }
            n/=10;
        }
        return true;
    }
}