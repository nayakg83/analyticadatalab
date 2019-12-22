package src.main.java.com.analytica.module.factory;

import src.main.java.com.analytica.module.GameModule;
import src.main.java.com.analytica.module.NumberGameModule;
import src.main.java.com.analytica.module.SymbolGameModule;

/**
 * @author gopal
 * @since 22/12/19
 */
public class GameModuleFactory {

    public static GameModule getGameModule(int type){

        GameModule gameModule = null;
        switch (type) {
            case 1:
                gameModule = new SymbolGameModule();
                break;
            case 2:
                gameModule = new NumberGameModule();
                break;
            default:
                System.out.println("Please choose valid game type");

        }
        return  gameModule;
    }

}
