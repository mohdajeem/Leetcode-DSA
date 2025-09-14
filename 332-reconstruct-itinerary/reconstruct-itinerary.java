class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, Integer> strToInd = new HashMap<>();
        HashMap<Integer, String> indToStr = new HashMap<>();
        int k =0;
        for(List<String> lst : tickets){
            String s1 = lst.get(0);
            String s2 = lst.get(1);
            if(!strToInd.containsKey(s1)){
                strToInd.put(s1, k);
                indToStr.put(k++, s1);
            }
            if(!strToInd.containsKey(s2)){
                strToInd.put(s2, k);
                indToStr.put(k++, s2);
            }
        }
        List<PriorityQueue<String>> adj = new ArrayList<>();
        for(int i =0;i<k;i++) adj.add(new PriorityQueue<>());

        for(List<String> lst : tickets){
            int uInd = strToInd.get(lst.get(0));
            adj.get(uInd).add(lst.get(1));
        }
        Stack<String> st = new Stack<>();
        List<String> res = new ArrayList<>();
        st.push("JFK");
        while(!st.isEmpty()){
            String node = st.peek();
            if(!adj.get(strToInd.get(node)).isEmpty()){
                String str = adj.get(strToInd.get(node)).remove();
                st.push(str);
            } else{
                res.add(st.pop());
            }
        }
        Collections.reverse(res);
        return res;

    }
}