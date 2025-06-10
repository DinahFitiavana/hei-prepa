package model;
public class SnakeBuilder {
    public static Snake buildDefault(){
        return new Snake(new Point(5,5), Direction.RIGHT, 3);
    }
}
