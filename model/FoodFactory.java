package model;

import java.util.List;
import java.util.Random;

public class FoodFactory {
    private Random random = new Random();

    public Point generate (List<Point> snakeBody){
        Point food;
        do{
            food = new Point(random.nextInt(10), random.nextInt(10));
        }while(snakeBody.contains(food));

        return food;
    }
}
