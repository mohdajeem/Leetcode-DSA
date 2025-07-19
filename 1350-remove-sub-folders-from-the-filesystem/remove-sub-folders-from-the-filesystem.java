class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        Arrays.sort(folder);
        int n = folder.length, i =0;
        for(String st : folder) System.out.println(st);
        List<String> ans = new ArrayList<>();
        while(i<n){
            String last = folder[i];
            ans.add(last);
            i++;
            int lastLen = last.length();
            while(i<n  && folder[i].length() >= last.length()+2 && folder[i].substring(0,lastLen).equals(last) && folder[i].charAt(lastLen)=='/'){
                i++;
            }
        }

        return ans;
    }
}