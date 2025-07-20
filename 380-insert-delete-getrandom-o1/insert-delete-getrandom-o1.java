class RandomizedSet {
    ArrayList<Integer> list;
    int size;
    HashMap<Integer, Integer> map;
    public RandomizedSet() {
        size=0;
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))  return false;
        size++;
        list.add(val);
        map.put(val, size-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int ind = map.get(val);
        int temp = list.get(size-1);
        list.set(ind,temp);
        list.remove(size-1);
        map.put(temp,ind);
        map.remove(val);
        size--;
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int randInd = rand.nextInt(size);
        return list.get(randInd);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */