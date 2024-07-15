class FileSystem {
    Trie trie;
    public FileSystem() {
        trie = new Trie();
    }
    
    public List<String> ls(String path) {
        String[] components = path.split("/");
        var ans = trie.getAll(components);
        Collections.sort(ans);
        return ans;
    }
    
    public void mkdir(String path) {
        String[] components = path.split("/");
        // System.out.println(path+" "+components.length);
        trie.insert(components, false, "");
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] components = filePath.split("/");
        trie.insert(components, true, content);
    }
    
    public String readContentFromFile(String filePath) {
        String[] components = filePath.split("/");
        return trie.getContent(components);
    }

    class Trie
    {
        HashMap<String,Trie> refs;
        boolean isFile;
        String content;
        public Trie()
        {
            refs = new HashMap<>();
            isFile = false;
            content = "";
        }
        public void insert(String[] path, boolean isFile, String content)
        {
            Trie current = this;
            for(int i=1; i<path.length; i++)
            {
                if(!current.refs.containsKey(path[i]))
                {
                    // System.out.println("adding content: "+path[i]);
                    current.refs.put(path[i], new Trie());
                }
                current = current.refs.get(path[i]);
            }
            current.isFile = isFile;
            if(current.isFile)
            {
                current.content += content;
            }
        }
        public ArrayList<String> getAll(String[] path)
        {
            ArrayList<String> ans = new ArrayList<>();
            Trie current = this;
            if(path.length == 0)
            {
                ans.addAll(new ArrayList<String>(current.refs.keySet()));
                return ans;
            }
            for(int i=1; i<path.length-1; i++)
            {
                current = current.refs.get(path[i]);
            }
            if(current.refs.get(path[path.length - 1]).isFile)
            {
                ans.add(path[path.length-1]);
                return ans;
            }
            current = current.refs.get(path[path.length-1]);
            ans.addAll(current.refs.keySet());
            return ans;
        }
        public String getContent(String[] path)
        {
            Trie current = this;
            for(int i=1; i<path.length; i++)
            {
                current = current.refs.get(path[i]);
            }
            return current.content;
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */