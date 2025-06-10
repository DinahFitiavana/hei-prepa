package strategy;

import model.Direction;
import model.Point;
import model.Snake;

public class DefaultMoveStrategy implements MoveStrategy{

    @Override
    public Point computeNextPosition(Snake snake, Direction inputDirection) {
        Point head = snake.getHead();
        Direction direction = inputDirection;

        switch (direction) {
            case UP: return new Point(head.x, head.y-1);
            case DOWN: return new Point(head.x, head.y+1);
            case LEFT: return new Point(head.x-1, head.y);
            case RIGHT: return new Point(head.x+1, head.y);
        }
        return head;
    }
    
}
