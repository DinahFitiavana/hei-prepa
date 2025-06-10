package game;

import java.util.Arrays;
import java.util.Scanner;

import model.Direction;
import model.Point;
import model.Snake;
import strategy.DefaultMoveStrategy;
import strategy.MoveStrategy;

public class RunningState implements GameState{
    private final Scanner scanner = new Scanner(System.in);
    private final MoveStrategy moveStrategy = new DefaultMoveStrategy();
    private Point food = null;

    @Override
    public void tick(Game game) {
        Snake snake = game.getSnake();

        String input = scanner .nextLine().toUpperCase();
        Direction newDirection = switch(input){
            case "W" -> Direction.UP;
            case "S" -> Direction.DOWN;
            case "A" -> Direction.LEFT;
            case "D" -> Direction.RIGHT;
            default -> snake.getDirection();
        };
        snake.setDirection(newDirection);

        Point next = moveStrategy.computeNextPosition(snake, newDirection);
        if (next.x < 0 || next.x >= 10 || next.y < 0 || next.y >= 10 || snake.collides(next)) { 
            game.setState(new GameOverState());
            return;
        }

        if (food == null) {
            food = game.getFoodFactory().generate(snake.getBody());
        }

        if (next.equals(food)) {
            snake.grow(next);
            food = null;
        }else{
            snake.move(next);
        }

        draw(snake, food);
    }

    private void draw(Snake snake, Point food){
        char [][] grid = new char [10][10];
        for (char [] row : grid)
            Arrays.fill(row,'.');

        for (Point point : snake.getBody())
            grid[point.y][point.x] = '*';

        if (food != null)
            grid[food.y][food.x] = '@';

        for (char[] row : grid){
            for (char c : row)
                System.out.println(c + "");
            System.out.println();
        }         
  }
    
}
