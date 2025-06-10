package model;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    private LinkedList<Point> body;
    private Direction direction;

    public Snake(Point start, Direction direction, int length){
        this.direction = direction;
        this.body = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            body.add(new Point(start.x-i, start.y));
        }
    }

    public List<Point> getBody (){
        return body;
    }

    public Point getHead (){
        return body.getFirst();
    }

    public void grow(Point next){
        body.addFirst(next);
    }

    public void move (Point next){
        body.addFirst(next);
        body.removeLast();
    }

    public boolean collides (Point point){
        return body.contains(point);
    }

    public void setDirection (Direction direction){
        this.direction = direction;
    }

    public Direction getDirection (){
        return direction;
    }
}
