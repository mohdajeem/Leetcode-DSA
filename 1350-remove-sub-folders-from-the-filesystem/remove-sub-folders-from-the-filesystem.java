class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        int n = folder.length, i =1;
        List<String> ans = new ArrayList<>();
        String last = folder[0];
        ans.add(last);
        while(i<n){
           String curr = folder[i];
           if(!curr.startsWith(last+'/')){
            last = curr;
            ans.add(curr);
           }
           i++;
        }

        return ans;
    }
}