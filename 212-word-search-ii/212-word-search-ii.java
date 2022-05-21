class Trie{
    Trie child[];
    String flag;
    int ends;
    Trie(){
        child = new Trie[26];
        flag = "";
        ends = 0;
        for(int i = 0; i < 26; i++){
            child[i] = null;
        }
    }
    
    public void insert(Trie root, String s){
        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i)-97;
            if(root.child[idx] == null) root.child[idx] = new Trie();
            root = root.child[idx];
        }
        root.ends += 1;
        root.flag = s;
    }
}

class Solution {
    Set<String> res = new HashSet<>();
    
    public void dfs(char[][] board, int i, int j, int r, int c, Trie root){
        int idx = board[i][j] - 'a';
        if(board[i][j] == '*' || root.child[idx] == null) return;
        
        root = root.child[idx];
        
        if(root.ends > 0){
            res.add(root.flag);
            root.ends -= 1;
        }
        
        char ch = board[i][j];
        board[i][j] = '*';
        
        if(i > 0) dfs(board, i-1, j, r, c, root);
        if(i < r-1) dfs(board, i+1, j, r, c, root);
        if(j > 0) dfs(board, i, j-1, r, c, root);
        if(j < c-1) dfs(board, i, j+1, r, c, root);
        
        board[i][j] = ch;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for(String word: words) root.insert(root, word);
        
        for(int i  = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, board.length, board[0].length, root);
            }
        }
        
        return new ArrayList<String>(res);
        
    }
}