class RandomizedCollection {
    HashMap<Integer,LinkedHashSet<Integer>> indexMap;
    List<Integer> numbers;
    public RandomizedCollection() {
        indexMap = new HashMap<>();
        numbers = new ArrayList<Integer>();
    }
    
    public boolean insert(int val) {
        numbers.add(val);
        if(indexMap.containsKey(val))
        {
            indexMap.get(val).add(numbers.size() - 1);
            return false;
        }
        else
        {
            indexMap.put(val, new LinkedHashSet<>());
            indexMap.get(val).add(numbers.size() - 1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!indexMap.containsKey(val))
        {
            return false;
        }
        int index = indexMap.get(val).iterator().next();
        indexMap.get(val).remove(index);
        int lastElement = numbers.get(numbers.size() - 1);
        numbers.set(index, lastElement);
        indexMap.get(lastElement).add(index);
        indexMap.get(lastElement).remove(numbers.size() - 1);

        numbers.remove(numbers.size() - 1);

        if(indexMap.get(val).size() == 0)
        {
            indexMap.remove(val);
        }
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(numbers.size());
        return numbers.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */