package src.main.java.com.analytica.module;

import src.main.java.com.analytica.common.GameConstants;

/**
 * @author gopal
 * @since 22/12/19
 */
public class GameModule {

    static final int firstPlayer = 1, secondPlayer = -1;
    boolean isEmpty = false;
    int player = 1;

    protected String getNonOccupiedPosition(int[][] playBoard) {
        for(int i=0;i<playBoard.length;i++){
            for(int j=0;j<playBoard.length;j++){
                if(playBoard[i][j] == 0){
                    return i+" "+j;
                }
            }
        }
        return null;
    }


    protected String toString(int[][] playBoard, boolean isComputerChosen){

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
                    case GameConstants.EMPTY:
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
