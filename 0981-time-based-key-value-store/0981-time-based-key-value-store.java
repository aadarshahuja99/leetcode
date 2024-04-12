class TimeMap {
    HashMap<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
        {
            TreeMap<Integer,String> valuesMap = new TreeMap<>();
            valuesMap.put(timestamp, value);
            map.put(key, valuesMap);
        }
        else
        {
            map.get(key).put(timestamp, value);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
        {
            return "";
        }
        var floor = map.get(key).floorEntry(timestamp);
        if(floor == null)
        {
            return "";
        }
        return floor.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */