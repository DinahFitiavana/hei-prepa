package game;

public class GameOverState implements GameState{

    @Override
    public void tick(Game game) {
        System.out.println("Game over");
        System.exit(0);
    }
    
}
