public class TicTacToe {
    private String f[][];
    private boolean gameOver;
    private String move;
    private int moveCount;

    public TicTacToe() {
        newGame();
    }

    public void newGame() {
        f = new String[][]{{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
        moveCount = 0;
        move = "X";
        gameOver = false;
    }

    public String[][] getField() {
        for( int i = 0; i < 3; i++ ){
            System.out.print(f[i][0]+", ");
            System.out.print(f[i][1]+", ");
            System.out.println(f[i][2]);
        }
        return f;
    }

    private boolean checkLine( String o[], String t[] ){
        for ( int i = 0; i < 3; i++ )
            if (!o[i].equals( t[i] ) ) return false;
        return true;
    }

    private boolean checkForGamer(String c) {
        gameOver = true;
        String fm[][] = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
        String w[] = {"-", "-", "-"};
        for (int i = 0; i < 3; i++) w[i] = c;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++ )
                fm[i][j] = f[j][i];

        for (int i = 0; i < 3; i++) {
            if ( checkLine(f[i], w) ) return true;
            if ( checkLine(fm[i], w) )return true;
        }
        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i < 3; i++) {
            if (f[i][i].equals(c)) d1 += 1;
            if (f[i][2-i].equals(c)) d2 += 1;
        }
        if (d1 == 3 || d2 == 3) return true;
        gameOver = false;
        return false;
    }

    public String checkGame() {
        if (checkForGamer(move))
            return move;
        else if (moveCount == 9)
            return "D";
        return null;
    }

    public String makeMove(int x, int y) {
        if (gameOver) return "Game was ended";
        if (moveCount == 9) return "Game was ended";
        if (x < 1 || x > 3) return "Error";
        if (y < 1 || y > 3) return "Error";
        if ( !f[x-1][y-1].equals("-") ) return "Cell " + x + ", " + y + " is already occupied";
        f[x-1][y-1] = move;
        moveCount += 1;
        String res = checkGame();
        if( res == null )
            res = "Move completed";
        else if (res.equals("X"))
                res = "Player X won";
        else if ( res.equals("0") )
            res = "Player 0 won";
        else if ( res.equals("D") )
            res = "Draw";
        else
            res = "Error";
        move = move.equals("X") ? "0" : "X";
        return res;
    }
}
