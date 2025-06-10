package strategy;

import model.Direction;
import model.Point;
import model.Snake;

public interface MoveStrategy {
    Point computeNextPosition (Snake snake, Direction inputDirection);
}
