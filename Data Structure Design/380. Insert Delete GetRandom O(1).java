class RandomizedSet {
    List<Integer>al;
    Map<Integer,Integer>map;
    java.util.Random rand = new java.util.Random();
    public RandomizedSet() {
        al=new ArrayList<>();
        map=new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
        return false;
        al.add(val);
        map.put(val, al.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
        return false;

        int idxToRemove=map.get(val);
        if(idxToRemove<al.size()-1){
            int lastEltOfList=al.get(al.size()-1);
            al.set(idxToRemove, lastEltOfList);
            map.put(lastEltOfList, idxToRemove);
        }
        map.remove(val);
        al.remove(al.size()-1);
        return true;
    }
    
    public int getRandom() {
        int idx= (int) Math.random()*al.size();
        return al.get(idx);
        // return al.get( rand.nextInt(al.size()) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */