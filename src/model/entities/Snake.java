package model.entities;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    private LinkedList<Position> tail = new LinkedList<>();
    private Position pos;

    public Snake() {
        this.pos = new Position(2, 15 / 2);
        tail.addFirst(pos);
        grow(1, 15/2);
    }

    public void grow(int x, int y) {
        tail.add(new Position(x, y));
    }

    public List<Position> getSnakeBody() {
        return tail;
    }

}
