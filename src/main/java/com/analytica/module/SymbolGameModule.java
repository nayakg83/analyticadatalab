package src.main.java.com.analytica.module;

import src.main.java.com.analytica.common.GameConstants;

import java.util.Scanner;

/**
 * @author gopal
 * @since 22/12/19
 */
public class SymbolGameModule extends GameModule{


    private void markSymbolBoard(int[][] playBoard, int x, int y, int player){

        if(x < 0 || x > 2 || y < 0 || y > 2){
            System.out.println("selected invalid position");
            return;
        }if(playBoard[x][y] != GameConstants.EMPTY){
            System.out.println("board position already taken");
            return;
        }

        playBoard[x][y] = player;
        this.player = -player;
    }

    private boolean hasWonWithSymbol(int player, int[][] playBoard){

        return ((playBoard[0][0] + playBoard[0][1] + playBoard[0][2] == player * 3) ||
                (playBoard[1][0] + playBoard[1][1] + playBoard[1][2] == player * 3) ||
                (playBoard[2][0] + playBoard[2][1] + playBoard[2][2] == player * 3) ||
                (playBoard[0][0] + playBoard[1][0] + playBoard[2][0] == player * 3) ||
                (playBoard[0][1] + playBoard[1][1] + playBoard[2][1] == player * 3) ||
                (playBoard[0][2] + playBoard[1][2] + playBoard[2][2] == player * 3) ||
                (playBoard[0][0] + playBoard[1][1] + playBoard[2][2] == player * 3) ||
                (playBoard[0][2] + playBoard[1][1] + playBoard[2][0] == player * 3));
    }


    private void printWinner(boolean isComputerChosen, int[][] playBoard){

        if (hasWonWithSymbol(firstPlayer, playBoard)) {
            System.out.println("first player won");
            isEmpty = false;
        } else if (hasWonWithSymbol(secondPlayer, playBoard)) {
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


    public void startSymbolGame(boolean isComputerChosen, int[][] playBoard, final Scanner scanner){

        int x,y;
        do{
            System.out.println(this.player == firstPlayer ?"first player turn": isComputerChosen ? "computer turn" : "second player turn");
            if(isComputerChosen && this.player == secondPlayer) {
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

            this.markSymbolBoard(playBoard, x, y, this.player);
            System.out.println(this.toString(playBoard, isComputerChosen));
            this.printWinner(isComputerChosen, playBoard);
        }while (this.isEmpty);

    }

}
