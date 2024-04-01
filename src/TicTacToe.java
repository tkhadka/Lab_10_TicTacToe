/*
Pseudo code outline for Tic Tac Toe game in Java:

1. Define the Tic Tac Toe class
2. Declare class level variables:
   - BOARD_SIZE: The size of the game board (3x3)
   - gameBoard: 2D array to represent the game board
   - currentPlayer: Tracks the current player (X or O)

3. Define the main method:
   - Start loop for playing multiple games
     - Clear the game board
     - Display the initial game board
     - Start loop for a single game
       - Ask the current player for row and column input
       - Make sure the user input is valid move
       - Update the game board with the player's move
       - Check for win or tie conditions
         - If win or tie, display the result and break the game loop
       - Change the current player for the next move
       - Display the updated game board
     - Prompt the players if they want to play again
       - Update the playAgain variable based on user input
       - Reset the game board and current player for a new game

4. Define method to clear the game board:
   - Loop through each cell in the game board and set it to empty

5. Define method to display the game board:
   - Loop through each row and print row index and cell values

6. Define method to check if a move is valid:
   - Check if the specified cell is empty

7. Define method to check if a player has won:
   - Check for win conditions in rows, columns, and diagonals

8. Define method that checks for a col win for specified player

9. Define method that checks for a row win for the specified player

10. Define method that checks for a diagonal win for the specified player

8. Define method to check if the game is a tie:
   - Check if all cells are filled without a winner
*/

import java.util.Scanner;

public class TicTacToe {
    // Class level variables
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];
    private static String currentPlayer = "X"; // X will always move first

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            clearBoard();
            display();

            while (true) {
                int row = SafeInput.getRangedInt(scanner, "Enter the row (1-3): ", 1, 3) - 1;
                int col = SafeInput.getRangedInt(scanner, "Enter the column (1-3): ", 1, 3) - 1;

                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    if (isWin(currentPlayer)) {
                        display();
                        System.out.println("Player " + currentPlayer + " wins!");
                        break;
                    } else if (isTie()) {
                        display();
                        System.out.println("It's a tie!");
                        break;
                    }
                    // Switch players
                    currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
                    display();
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            }

            // Prompt for playing again
            playAgain = SafeInput.getYNConfirm(scanner, "Do you want to play again? (y/n): ");
            currentPlayer = "X"; // Reset player to X for new game
        }
        scanner.close();
    }

    // sets all the board elements to a space
    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }

    // shows the Tic Tac Toe game used as part of the prompt for the users move choice
    private static void display() {
        System.out.println("  1 2 3");
        for (int i = 0; i < ROW; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < COL; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // returns true if there is a space at the given proposed move coordinates which means it is a legal move.
    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

   // checks to see if there is a win state on the current board for the specified player (X or O) This method in turn calls three additional methods that break down the 3 kinds of wins that are possible.
    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    // checks for a col win for specified player
    private static boolean isColWin(String player) {
        for (int i = 0; i < COL; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }

    // checks for a row win for the specified player
    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROW; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    // checks for a diagonal win for the specified player
    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    // checks for a tie condition: all spaces on the board are filled OR there is an X and an O in every win vector (i.e. all possible 8 wins are blocked by having both and X and an O in them.)
    private static boolean isTie() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}
