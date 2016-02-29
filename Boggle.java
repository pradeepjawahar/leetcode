public class Boggle {
    private static char[][] board = { {'H', 'E', 'L', 'L'},
                                      {'A', 'T', 'X', 'P'},
                                      {'T', 'Z', 'O', 'Y'},
                                      {'E', 'S', 'F' ,'C'}};
    private static boolean search(String word, char[][] board) {
        char[] w = word.toCharArray();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length;y++) {
                if (exists(board, x, y, 0, w)) 
                    return true;           
            }
        }
        return false;
    }

    private static boolean exists(char[][] board, int x, int y, int i, char[] word) {
        if (i == word.length)
            return true;
        if (x<0 || y<0 || x > board.length - 1 || y > board[x].length - 1)
            return false;
        if (board[x][y] != word[i])
            return false;
        board[x][y] = '*';
        boolean exist = exists(board, x, y+1, i+1, word)
                        || exists(board, x , y-1, i+1,word)
                        || exists(board, x-1, y, i+1, word)
                        || exists(board, x+1,y, i+1,word);
        board[x][y] = word[i];
        return exist;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(search("HATE", board));
        System.out.println(search("HELL", board));
        System.out.println(search("FOX", board));
    }

    private static boolean exist(char[][] board, int y, int x, char[] word, int i) {
    if (i == word.length) return true;
    if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
    if (board[y][x] != word[i]) return false;
    board[y][x] ^= 256;
    boolean exist = exist(board, y, x+1, word, i+1)
        || exist(board, y, x-1, word, i+1)
        || exist(board, y+1, x, word, i+1)
        || exist(board, y-1, x, word, i+1);
    board[y][x] ^= 256;
    return exist;
  }
}
