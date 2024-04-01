import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String currentPlayer = "X";
        clearBoard();
        display();
        boolean isValidMove = false;

        do {
            //clearBoard();
            //display();


            int row = SafeInput.getRangedInt(in, "Enter row [1-3] ", 1, 3) - 1;
            int col = SafeInput.getRangedInt(in, "Enter column [1-3] ", 1, 3) - 1;

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;

                display();

                if (isWin(currentPlayer)) {
                    System.out.println(currentPlayer + " wins ");
                    break;
                } else if (isTie()) {
                    System.out.println("Tie game");
                    break;
                }
                if (currentPlayer.equals("X")) {
                    currentPlayer = "O";
                } else {
                    currentPlayer = "X";
                }
            } else {
                System.out.println("Invalid move, try again");
            }
        } while (true);
    }

    private static void clearBoard() //sets all the board elements to a space
    {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " ";
            }
        }
    }

    private static void display() //shows the Tic Tac Toe game used as part of the prompt for the users move choice
    {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                System.out.print(board[row][col]);
                if (col < COL - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < ROW - 1) {
                System.out.println("---------");
            }
        }
    }

    private static boolean isValidMove(int row, int col) {
        //returns true if there is a space at the given proposed move coordinates which means it is a legal move.
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
    }
    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false; //no row win
    }
    private static boolean isColWin(String player) {
        for (int col = 0; col < COL; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false; //no column win
    }
    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player));
    }
    private static boolean isTie() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (board[row][col].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}