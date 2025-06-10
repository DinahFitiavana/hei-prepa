package game;

import java.util.Scanner;

public class MenuState implements GameState{

    @Override
    public void tick(Game game) {
        System.out.println("Appuyez sur entrée pour démarrer le jeu.");
        new Scanner(System.in).nextLine();
        game.setState(new RunningState());
    }

}
