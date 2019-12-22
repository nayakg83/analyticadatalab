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
        if(checkFirstPlayerWinningPossibility(playBoard) == null){
            for(int i=0;i<playBoard.length;i++){
                for(int j=0;j<playBoard.length;j++){
                    if(playBoard[i][j] == 0){
                        return i+" "+j;
                    }
                }
            }
        }else{
            return checkFirstPlayerWinningPossibility(playBoard);
        }
        return null;
    }



    private String checkFirstPlayerWinningPossibility(int[][] playBoard) {


        if(playBoard[0][0] + playBoard[0][1] + playBoard[0][2] == 2) {
            if(playBoard[0][0] == 0){
                return 0+" "+0;
            }if(playBoard[0][1] == 0){
                return 0+" "+1;
            }if(playBoard[0][2] == 0){
                return 0+" "+2;
            }

        }
        if(playBoard[1][0] + playBoard[1][1] + playBoard[1][2] == 2) {

            if(playBoard[1][0] == 0){
                return 1+" "+0;
            }if(playBoard[1][1] == 0){
                return 1+" "+1;
            }if(playBoard[1][2] == 0){
                return 1+" "+2;
            }

        }
        if(playBoard[2][0] + playBoard[2][1] + playBoard[2][2] == 2) {

            if(playBoard[2][0] == 0){
                return 2+" "+0;
            }if(playBoard[2][1] == 0){
                return 2+" "+1;
            }if(playBoard[2][2] == 0){
                return 2+" "+2;
            }

        }
        if(playBoard[0][0] + playBoard[1][0] + playBoard[2][0] == 2) {

            if(playBoard[0][0] == 0){
                return 0+" "+0;
            }if(playBoard[1][0] == 0){
                return 1+" "+0;
            }if(playBoard[2][0] == 0){
                return 2+" "+0;
            }

        }
        if(playBoard[0][1] + playBoard[1][1] + playBoard[2][1] == 2) {

            if(playBoard[0][1] == 0){
                return 0+" "+1;
            }if(playBoard[1][1] == 0){
                return 1+" "+1;
            }if(playBoard[2][1] == 0){
                return 2+" "+1;
            }
        }
        if(playBoard[0][2] + playBoard[1][2] + playBoard[2][2] == 2) {

            if(playBoard[0][2] == 0){
                return 0+" "+2;
            }if(playBoard[1][2] == 0){
                return 1+" "+2;
            }if(playBoard[2][2] == 0){
                return 2+" "+2;
            }
        }
        if(playBoard[0][0] + playBoard[1][1] + playBoard[2][2] == 2) {

            if(playBoard[0][0] == 0){
                return 0+" "+0;
            }if(playBoard[1][1] == 0){
                return 1+" "+1;
            }if(playBoard[2][2] == 0){
                return 2+" "+2;
            }

        }
        if(playBoard[0][2] + playBoard[1][1] + playBoard[2][0] == 2){

            if(playBoard[0][2] == 0){
                return 0+" "+2;
            }if(playBoard[1][1] == 0){
                return 1+" "+1;
            }if(playBoard[2][0] == 0){
                return 2+" "+0;
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
