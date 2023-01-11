class RandomizedSet {
    HashSet<Integer> setty;
    public RandomizedSet() {
        setty = new HashSet();
    }
    
    public boolean insert(int val) {
        return setty.add(val);
    }
    
    public boolean remove(int val) {
        return setty.remove(val);
    }
    
    public int getRandom() {
        Random random = new Random();
        Integer[] array = setty.toArray(new Integer[setty.size()]);
        int value = random.nextInt(array.length);
        int toReturn = array[value];
        return toReturn;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */