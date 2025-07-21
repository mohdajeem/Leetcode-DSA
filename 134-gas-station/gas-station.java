class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalTank = 0;
        for(int i =0;i<n;i++){
            totalTank += gas[i]-cost[i];
        }
        if(totalTank < 0) return -1;

        int ansInd = 0;
        int currTank = 0;
        for(int i =0;i<n;i++){            
            currTank += (gas[i]-cost[i]);
            if(currTank < 0){
                ansInd = i+1;
                currTank = 0;
            }
        }
        return ansInd;
    }
}