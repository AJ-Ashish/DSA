class Solution {
    class TrieNode {
        boolean isEndOfWord;;
        HashMap<String, TrieNode> children;
        TrieNode() {
            isEndOfWord = false;
            children = new HashMap<>();
        }
    }
    

    void insert(TrieNode root, String folder) {
        String parts[] = folder.split("/");
        TrieNode crawler = root;

        for(int i=1; i<parts.length; i++) {
            if(!crawler.children.containsKey(parts[i])) {
                crawler.children.put(parts[i], new TrieNode());
            }
            crawler = crawler.children.get(parts[i]);
            if(crawler.isEndOfWord) {
                return;
            }
        }
        crawler.isEndOfWord = true;
    }
    void collectFolders(TrieNode node, String path, List<String> result) {
        if(node.isEndOfWord) {
            result.add(path);
            return;
        }
        for(Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            String newPath = path + "/" + entry.getKey();   
            collectFolders(entry.getValue(), newPath, result);     
        }
    }
    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode();

        for(int i=0; i<folder.length; i++) {
            insert(root, folder[i]);
        }
        List<String> result = new ArrayList<>();
        collectFolders(root,"",result);
        return result;
    }
}