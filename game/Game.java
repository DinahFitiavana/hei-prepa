package game;

import model.FoodFactory;
import model.Snake;
import model.SnakeBuilder;

public class Game {
    private GameState state;
    private  Snake snake;
    private FoodFactory foodFactory;

    public Game(){
        this.state = new MenuState();
        this.snake = SnakeBuilder.buildDefault();
        this.foodFactory = new FoodFactory();
    }

    public void setState (GameState state){
        this.state = state;
    }

    public Snake getSnake(){
        return snake;
    }

    public FoodFactory getFoodFactory(){
        return foodFactory;
    }

    public void run (){
        while (true) {
            state.tick(this);
        }
    }   
}
