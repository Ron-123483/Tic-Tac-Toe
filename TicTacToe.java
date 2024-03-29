import java.util.Scanner;

public class TicTacToe {
    final static char circle = 'O';
    final static char cross = 'X';

    /**
     * Display the current state of the tic-tac-toe board to the screen
     *
     * @param board 2D char array of chars
     */
    static void displayBoard(char[][] board) {
        System.out.println("+---+---+---+");
        for (int row = 0; row < board.length; row++) {
            System.out.printf("| %c | %c | %c |\n", board[row][0], board[row][1], board[row][2]);
            System.out.println("+---+---+---+");
        }
    }

    /**
     * Determine if the current board is a winning board.
     *
     * @param board 2D char array of current tic-tac-toe board.
     * @return true or false on whether the current board is a winner
     */
    static boolean checkWinner(char[][] board) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') ||
                    (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')) {
                return true;  // Found a winning row or column
            }
        }

        // Check diagonals
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')) {
            return true;  // if Found a winning diagonal
        }

        return false;  // No winning conditions found so false
    }

    /**
     * Inserts a move to the board and returns true. If a move cannot be inserted false is returned.
     *
     * @param board       2D char array of current tic-tac-toe board.
     * @param row         Row number for the move.
     * @param column      Column number for the move.
     * @param currentMove Current player's move ('X' or 'O').
     * @return true or false on whether the currentMove can be inserted into the board
     */
    static boolean insertMove(char[][] board, int row, int column, char currentMove) {
        if (row < 0 || row >= 3 || column < 0 || column >= 3 || board[row][column] != ' ') {
            System.out.println("\nInvalid move. Please try again.");
            return false;
        }

        board[row][column] = currentMove;
        return true;
    }


    // You may implement tic-tac-toe in the following way
//        // 1. create your variables for your program
//        // 2. initialize your tic-tac-toe board.
//        // 3. begin game loop
//        //     3.1 display current state of tic-tac-toe board
//        //     3.2 prompt user for move
//        //     3.3 attempt to insert move into board
//        //         3.3.1 if move cannot be inserted let the user know and ask for another move
//        //        (note this can be another method as well but is optional)
//        //     3.4 check board to see if there is a winner
//        //         if there is a winner, display who won and exit.
//        //         if there is no winner, switch to other player


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char currentMove = cross;
        int row, column;
        int movesMade = 0;
        final int maxMoves = 9; // Maximum number of moves without a winner so it's going to be 9 moves on 3x3

        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };

        // This part was little tricky because I had to move a lot of methods

        while (true) {
            displayBoard(board);
            System.out.printf("Player %c enter move (row col): ", currentMove);
            row = in.nextInt();
            column = in.nextInt();

            if (insertMove(board, row, column, currentMove)) {
                movesMade++;

                if (checkWinner(board)) {
                    displayBoard(board);
                    System.out.printf("Player %c wins!\n", currentMove);
                    break;
                }

                // used outside source for this I was confused on this part
                if (movesMade == maxMoves) {
                    displayBoard(board);
                    System.out.println("The game is a tie!");
                    break;
                }

                // Switch to the other player  // used outside source for this I was confused on this part
                currentMove = (currentMove == cross) ? circle : cross;
            }
        }
    }
}










