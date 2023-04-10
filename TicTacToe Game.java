import java.util.*;
public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char board[][]=new char[3][3];

        //initializing an empty board
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++)
                board[row][col]=' ';
        }
        
        char player='X';
        boolean gameOver=false;
        while(!gameOver){
            printBoard(board);
            System.out.println("Player "+player+" enter :");
            int row=sc.nextInt();
            int col=sc.nextInt();
            System.out.println();
            //try to put current player at its choice
            if(board[row][col]==' '){
                board[row][col]=player;
                gameOver= haveOwn(board,player);
                if(gameOver){
                    System.out.println("Player "+player+" has won the Game .");

                }
                else if(boardAlreadyFull(board)==true){
                    gameOver=true;
                    System.out.println("Nobody won . Game ends as draw .");
                }
                else{
                    player=(player=='X')?'O':'X';
                }

            }else{
                System.out.println("Invalid move! . Re-try .");
            }
        }
        printBoard(board);

    }

    private static boolean boardAlreadyFull(char[][] board) {
        for(int row=0;row< board.length;row++){
            for(int col=0;col<board[row].length;col++){
                if(board[row][col]==' ')
                    return false;
            }
        }
        return true;
    }

    private static boolean haveOwn(char[][] board, char player) {
        //check row
        
        for(int row=0;row< board.length;row++){
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player)
                return true;
        }
        //check column
        for(int col=0;col< board[0].length;col++){
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player)
                return true;
        }
   //diagonal check
        
        //left
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player )
            return true;
        //right
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player )
            return true;

        return false;

    }


//printing board

    private static void printBoard(char[][] board) {
        for(int row=0;row< board.length;row++){
            for(int col=0;col<board[row].length;col++){
                System.out.print(board[row][col]+" | ");
            }
            System.out.println();
        }
    }
}
