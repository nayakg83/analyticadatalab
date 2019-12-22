package src.main.java.com.analytica.module;

import src.main.java.com.analytica.common.GameConstants;

import java.util.Scanner;

/**
 * @author gopal
 * @since 22/12/19
 */
public class NumberGameModule extends GameModule {


    private void markNumberBoard(int[][] playBoard, int x, int y, int z, int player, int[][] playTracker){

        if(x < 0 || x > 2 || y < 0 || y > 2){
            System.out.println("selected invalid position");
            return;
        }if(playBoard[x][y] != GameConstants.EMPTY){
            System.out.println("board position already taken");
            return;
        }
        playTracker[x][y] = player;
        playBoard[x][y] = z;
        this.player = -player;
    }


    private boolean hasWonWithNumber(int player, int[][] playBoard, int[][] playTracker){

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


    private void printWinner(int[][] playBoard, int[][] playTracker, boolean isComputerChosen){

        if (hasWonWithNumber(firstPlayer, playBoard, playTracker)) {
            System.out.println("first player won");
            isEmpty = false;
        } else if (hasWonWithNumber(secondPlayer, playBoard, playTracker)) {
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

    public void startNumberGame(boolean isComputerChosen, int[][] playBoard, final Scanner scanner){

        int x, y,z;
        int[][] playTracker = new int[3][3];
        do{
            System.out.println(this.player == GameModule.firstPlayer?"first player turn": isComputerChosen ? "computer turn" : "second player turn");
            if(isComputerChosen && this.player == GameModule.secondPlayer) {
                if(this.getNonOccupiedPosition(playBoard) != null){
                    String indexes = this.getNonOccupiedPosition(playBoard);
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
            if(this.player == secondPlayer && isComputerChosen){
                z = 5;
            }else {
                System.out.println("Enter a number");
                z = scanner.nextInt();
            }
            this.markNumberBoard(playBoard, x,y,z, player, playTracker);
            System.out.println(this.toString(playBoard, isComputerChosen));
            this.printWinner(playBoard, playTracker, isComputerChosen);
        }while (this.isEmpty);



    }

















}
