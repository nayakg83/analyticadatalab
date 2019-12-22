package src.test;

import src.main.java.com.analytica.module.factory.GameModuleFactory;
import src.main.java.com.analytica.module.GameModule;
import src.main.java.com.analytica.module.SymbolGameModule;
import src.main.java.com.analytica.module.NumberGameModule;

import java.util.Scanner;

/**
 * @author gopal
 * @since 11/11/19
 */
public class GameTester {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] playBoard = new int[3][3];
        System.out.println("Please choose 1 for symbol play or 2 number play");
        int usersChoice = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        GameModule gameModule = GameModuleFactory.getGameModule(usersChoice);

        System.out.println("Do you want to play with computer? true/false?");
        boolean isComputerChosen = scanner.nextBoolean();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if(gameModule instanceof SymbolGameModule){
            ((SymbolGameModule)gameModule).startSymbolGame(isComputerChosen, playBoard, scanner);
        }else if(gameModule instanceof NumberGameModule){
            ((NumberGameModule)gameModule).startNumberGame(isComputerChosen, playBoard, scanner);
        }
    }

}









