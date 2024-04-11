class SnapshotArray {
    private HashMap<Integer,TreeMap<Integer,Integer>> _snapshots;
    private int[] _values;
    private HashSet<Integer> _changedValues;
    private int _snapId;
    public SnapshotArray(int length) {
        _snapshots = new HashMap<>();
        for(int i=0; i<length; i++)
        {
            _snapshots.put(i, new TreeMap<>());
        }
        _values = new int[length];
        _snapId = 0;
        _changedValues = new HashSet<>();
    }
    
    public void set(int index, int val) {
        this._values[index] = val;
        this._changedValues.add(index);
    }
    
    public int snap() {
        int snapIdToBeReturned = this._snapId;
        this._snapId++;
        for(int index : this._changedValues)
        {
            this._snapshots.get(index).put(snapIdToBeReturned, this._values[index]);
        }
        this._changedValues = new HashSet<>();
        return snapIdToBeReturned;
    }
    
    public int get(int index, int snap_id) {
        var floor = _snapshots.get(index).floorEntry(snap_id);
        if(floor == null)
        {
            return 0;
        }
        return floor.getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */