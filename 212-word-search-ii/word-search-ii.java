class Solution {
    class TrieNode {
        boolean isEndOfWord = false;
        String word = "";
        TrieNode children[] = new TrieNode[26];
    }

    void insert(TrieNode root , String word) {
        TrieNode crawler =  root;

        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a';

            if(crawler.children[idx] == null) {
                crawler.children[idx] = new TrieNode();
            }
            crawler = crawler.children[idx];
        }
        crawler.isEndOfWord = true;
        crawler.word = word;
    }

    List<String> result;
    int directions[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    void dfs(char[][] board, int i, int j, TrieNode node) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        if(board[i][j] == '$' || node.children[board[i][j] - 'a'] == null ) {
            return;
        }
        node = node.children[board[i][j] - 'a'];

        if(node.isEndOfWord) {
            result.add(node.word);
            node.isEndOfWord = false;
        } 

        char temp = board[i][j];
        board[i][j] = '$';

        for(int[] direction : directions) {
            int new_i = i + direction[0];
            int new_j = j + direction[1];
            dfs(board, new_i, new_j, node);
        }
        board[i][j] = temp;
    }
    public List<String> findWords(char[][] board, String[] words) {
        result = new ArrayList<>();
        TrieNode root = new TrieNode();

        for(String word : words) {
            insert(root, word);
        }

        for(int i=0;i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int idx = board[i][j] - 'a';
                if(root.children[idx] != null){
                    dfs(board,i, j, root);
                }
            }
        }
        return result;
    }
}