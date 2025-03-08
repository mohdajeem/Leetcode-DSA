class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows==1){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            ans.add(new ArrayList<>(list));
            return ans;
        }
        for(int i=0;i<2;i++){
            ans.add(new ArrayList<>());
        }
        ans.get(0).add(1);
        ans.get(1).add(1);
        ans.get(1).add(1);
        for(int i=2;i<numRows;i++){
            List<Integer> list = ans.get(i-1);
            List<Integer> list2 = new ArrayList<>();
            list2.add(1);
            for(int j=1;j<list.size();j++){
                list2.add(list.get(j-1)+list.get(j));
            }
            list2.add(1);
            ans.add(new ArrayList<>(list2));
        }
        return ans;
    }
}