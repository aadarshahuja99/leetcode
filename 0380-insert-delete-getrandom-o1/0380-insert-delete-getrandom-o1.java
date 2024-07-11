class RandomizedSet {
    HashMap<Integer,Integer> map;
    List<Integer> list;
    int active;
    Random r;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        active = 0;
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
        {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        // System.out.println();
        // for(int i=0; i<list.size(); i++)
        // {
        //     System.out.print(list.get(i)+" ");
        //     if(i < active)
        //     {
        //         System.out.print(" act ");
        //     }
        // }
        // System.out.println(active);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
        {
            return false;
        }
        int index = map.get(val);
        // System.out.println(index+" "+list.size());
        int temp = list.get(list.size()-1);
        list.set(list.size()-1, val);
        list.set(index, temp);
        map.put(temp, index);
        map.remove(val);
        list.remove(list.size() - 1);
        // if(active > 0)
        // {
        //     System.out.println("2: "+list.get(active-1)+" "+val);
        // }
        return true;
    }
    
    public int getRandom() {
        int idx = r.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */