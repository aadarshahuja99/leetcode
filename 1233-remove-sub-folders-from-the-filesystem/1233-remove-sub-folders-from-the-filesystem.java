class Solution {
    public List<String> removeSubfolders(String[] folders) {
        Trie root = new Trie();
        
        // 1. Build the true folder hierarchy in the Trie
        for (String folder : folders) {
            String[] components = folder.split("/");
            Trie current = root;
            
            for (String component : components) {
                if (component.isEmpty()) continue; // Skip the leading empty string from split
                
                if (!current.children.containsKey(component)) {
                    current.children.put(component, new Trie());
                }
                current = current.children.get(component);
            }
            current.isFolder = true; // Mark the end of a valid folder path
        }
        
        List<String> ans = new ArrayList<>();
        
        // 2. Validate folders by tracking if we hit an earlier folder marker
        for (String folder : folders) {
            String[] components = folder.split("/");
            Trie current = root;
            boolean isSubfolder = false;
            
            for (int i = 0; i < components.length; i++) {
                String component = components[i];
                if (component.isEmpty()) continue;
                
                current = current.children.get(component);
                
                // If we hit a valid folder marker BEFORE reaching the final component,
                // it means this current folder is a subfolder!
                if (current.isFolder && i < components.length - 1) {
                    isSubfolder = true;
                    break;
                }
            }
            
            if (!isSubfolder) {
                ans.add(folder);
            }
        }
        
        return ans;
    }

    class Trie {
        Map<String, Trie> children = new HashMap<>();
        boolean isFolder = false;
    }
}
