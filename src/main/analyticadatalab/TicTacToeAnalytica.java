package src.main.analyticadatalab;

import java.util.Scanner;

/**
 * @author gopal
 * @since 11/11/19
 */
public class TicTacToeAnalytica {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please choose 1 for symbol play or 2 number play");
        int usersChoice = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println("Do you want to play with computer? true/false?");
        boolean isCcomputerChosen = scanner.nextBoolean();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


        TicTacToe ticTacToe = new TicTacToe();
        int x =0, y =0, z=0;
        do{

            System.out.println(ticTacToe.player == TicTacToe.firstPlayer?"first player turn": isCcomputerChosen ? "computer turn" : "second player turn");
            if(isCcomputerChosen && ticTacToe.player == TicTacToe.secondPlayer) {
                if(ticTacToe.getNonOccupiedPosition() != null){
                    String indexes = ticTacToe.getNonOccupiedPosition();
                    String[] values = indexes.split(" ");
                    x = Integer.valueOf(values[0]);
                    y = Integer.valueOf(values[1]);
                }else{
                    System.out.println("Sorry position left for computer. So ending the game as tie");
                    break;
                }
            }else{
                System.out.println("Enter x and y places");
                x = scanner.nextInt();
                y = scanner.nextInt();
            }
            if(usersChoice == 2){
                System.out.println("Enter a number");
                z = scanner.nextInt();
                ticTacToe.markNumberBoard(x,y,z);
            }else{
                ticTacToe.markSymbolBoard(x,y);
            }
            System.out.println(ticTacToe.toString(isCcomputerChosen));
            ticTacToe.printWinner(usersChoice, isCcomputerChosen);
        }while (ticTacToe.isEmpty);

    }

}


class TicTacToe {

    public static final int firstPlayer = 1, secondPlayer = -1;
    public static final int EMPTY = 0;

    public int player = firstPlayer;

    private int[][] playBoard = new int[3][3];
    private int[][] playTracker = new int[3][3];
    public boolean isEmpty = false;

    public String getNonOccupiedPosition() {
        for(int i=0;i<playBoard.length;i++){
            for(int j=0;j<playBoard.length;j++){
                if(playBoard[i][j] == 0){
                    return i+" "+j;
                }
            }
        }
        return null;
    }


    public void markSymbolBoard(int x, int y){

        if(x < 0 || x > 2 || y < 0 || y > 2){
            System.out.println("selected invalid position");
            return;
        }if(playBoard[x][y] != EMPTY){
            System.out.println("board position already taken");
            return;
        }

        playBoard[x][y] = player;
        player = -player;
    }


    public void markNumberBoard(int x, int y, int z){

        if(x < 0 || x > 2 || y < 0 || y > 2){
            System.out.println("selected invalid position");
            return;
        }if(playBoard[x][y] != EMPTY){
            System.out.println("board position already taken");
            return;
        }
        playTracker[x][y] = player;
        playBoard[x][y] = z;
        player = -player;
    }



    public boolean hasWonWithSymbol(int player){

        return ((playBoard[0][0] + playBoard[0][1] + playBoard[0][2] == player * 3) ||
                (playBoard[1][0] + playBoard[1][1] + playBoard[1][2] == player * 3) ||
                (playBoard[2][0] + playBoard[2][1] + playBoard[2][2] == player * 3) ||
                (playBoard[0][0] + playBoard[1][0] + playBoard[2][0] == player * 3) ||
                (playBoard[0][1] + playBoard[1][1] + playBoard[2][1] == player * 3) ||
                (playBoard[0][2] + playBoard[1][2] + playBoard[2][2] == player * 3) ||
                (playBoard[0][0] + playBoard[1][1] + playBoard[2][2] == player * 3) ||
                (playBoard[0][2] + playBoard[1][1] + playBoard[2][0] == player * 3));

    }

    public boolean hasWonWithNumber(int player){

        return ((playBoard[0][0] + playBoard[0][1] + playBoard[0][2] == 15) && (playTracker[0][0] + playTracker[0][1] + playTracker[0][2] == player * 3)||
                (playBoard[1][0] + playBoard[1][1] + playBoard[1][2] == 15) && (playTracker[1][0] + playTracker[1][1] + playTracker[1][2] == player * 3)||
                (playBoard[2][0] + playBoard[2][1] + playBoard[2][2] == 15) && (playTracker[2][0] + playTracker[2][1] + playTracker[2][2] == player * 3)||
                (playBoard[0][0] + playBoard[1][0] + playBoard[2][0] == 15) && (playTracker[0][0] + playTracker[1][0] + playTracker[2][0] == player * 3)||
                (playBoard[0][1] + playBoard[1][1] + playBoard[2][1] == 15) && (playTracker[0][1] + playTracker[1][1] + playTracker[2][1] == player * 3)||
                (playBoard[0][2] + playBoard[1][2] + playBoard[2][2] == 15) && (playTracker[0][2] + playTracker[1][2] + playTracker[2][2] == player * 3)||
                (playBoard[0][0] + playBoard[1][1] + playBoard[2][2] == 15) && (playTracker[0][0] + playTracker[1][1] + playTracker[2][2] == player * 3)||
                (playBoard[0][2] + playBoard[1][1] + playBoard[2][0] == 15) && (playTracker[0][2] + playTracker[1][1] + playTracker[2][0] == player * 3)
        );

    }




    public void printWinner(int usersChoice, boolean isComputerChosen){

        if(usersChoice == 1) {
            if (hasWonWithSymbol(firstPlayer)) {
                System.out.println("first player won");
                isEmpty = false;
            } else if (hasWonWithSymbol(secondPlayer)) {
                if(isComputerChosen)
                    System.out.println("computer won");
                else
                    System.out.println("second player won");
                isEmpty = false;
            } else {
                if (!isEmpty) {
                    System.out.println("It is a tie");
                }
            }
        }else{
            if (hasWonWithNumber(firstPlayer)) {
                System.out.println("first player won");
                isEmpty = false;
            } else if (hasWonWithNumber(secondPlayer)) {
                if(isComputerChosen)
                    System.out.println("computer won");
                else
                    System.out.println("second player won");
                isEmpty = false;
            } else {
                if (!isEmpty) {
                    System.out.println("It is a tie");
                }
            }
        }

    }

    public String toString(boolean isComputerChosen){

        StringBuilder sb = new StringBuilder();
        isEmpty = false;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                switch (playBoard[i][j]) {
                    case firstPlayer:
                        sb.append(" fist player ");
                        break;
                    case secondPlayer:
                        if(isComputerChosen)
                            sb.append("computer");
                        else
                            sb.append(" second player");
                        break;
                    case EMPTY:
                        sb.append(" ");
                        isEmpty = true;
                        break;
                }
                if (j < 2) {
                    sb.append("|");
                }
            }
            if(i<2){
                sb.append("|");
            }

            }
            return sb.toString();
        }



}









