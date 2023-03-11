public class Main {
    public static void main(String[] args) {
        TicTacToe board = new TicTacToe();
        board.getField();
        System.out.println(board.makeMove(1, 1));
        board.getField();
        System.out.println(board.makeMove(1, 1));
        System.out.println(board.makeMove(1, 2));
        board.getField();
        System.out.println(board.makeMove(2, 1));
        System.out.println(board.makeMove(2, 2));
        System.out.println(board.makeMove(3, 1));
        System.out.println(board.makeMove(2, 2));
        board.getField();
    }
}