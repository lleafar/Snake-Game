package model.entities;

public class Board {
    private final Integer boxSize = 16;
    private final Snake snake = new Snake();
    private Fruit fruit = new Fruit(boxSize);
    private char direction = 'D';

    public Board() {
    }

    public void setObjectPosition(Object obj, Position pos) {
        if (obj instanceof Snake) {
            snake.getSnakeBody().get(0).setxPos(pos.getxPos());
            snake.getSnakeBody().get(0).setyPos(pos.getyPos());
        } else if (obj instanceof Fruit) {
            fruit.setFruitPos(pos);
        }
    }

    public Snake getSnake() {
        return snake;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void move() {
        for (int i = snake.getSnakeBody().size() - 1; i > 0; i--) {
            snake.getSnakeBody().get(i).setxPos(snake.getSnakeBody().get(i - 1).getxPos());
            snake.getSnakeBody().get(i).setyPos(snake.getSnakeBody().get(i - 1).getyPos());
        }
        switch (direction) {
            case 'W':
                if (snake.getSnakeBody().get(0).getyPos() - 1 < 0) {
                    setObjectPosition(snake, new Position(snake.getSnakeBody().get(0).getxPos(), 15));
                } else {
                    setObjectPosition(snake, new Position(snake.getSnakeBody().get(0).getxPos(), snake.getSnakeBody().get(0).getyPos() - 1));
                }
                break;
            case 'A':
                if (snake.getSnakeBody().get(0).getxPos() - 1 < 0) {
                    setObjectPosition(snake, new Position(15, snake.getSnakeBody().get(0).getyPos()));
                } else {
                    setObjectPosition(snake, new Position(snake.getSnakeBody().get(0).getxPos() - 1, snake.getSnakeBody().get(0).getyPos()));
                }
                break;
            case 'S':
                if (snake.getSnakeBody().get(0).getyPos() + 1 > 15) {
                    setObjectPosition(snake, new Position(snake.getSnakeBody().get(0).getxPos(), 0));
                } else {
                    setObjectPosition(snake, new Position(snake.getSnakeBody().get(0).getxPos(), snake.getSnakeBody().get(0).getyPos() + 1));
                }
                break;
            case 'D':
                if (snake.getSnakeBody().get(0).getxPos() + 1 > 15) {
                    setObjectPosition(snake, new Position(0, snake.getSnakeBody().get(0).getyPos()));
                } else {
                    setObjectPosition(snake, new Position(snake.getSnakeBody().get(0).getxPos() + 1, snake.getSnakeBody().get(0).getyPos()));
                }
                break;
        }

        if (snake.getSnakeBody().get(0).getxPos().equals(fruit.getFruitPos().getxPos()) && snake.getSnakeBody().get(0).getyPos().equals(fruit.getFruitPos().getyPos())) {
            snake.grow(snake.getSnakeBody().get(0).getxPos() - snake.getSnakeBody().size() + 1, snake.getSnakeBody().get(0).getyPos());
            generateApple();
        }

    }

    public void setDirection(char c) {
        this.direction = c;
    }

    public boolean checkCollision() {
        for (int i = 1; i < snake.getSnakeBody().size(); i++) {
            if ((snake.getSnakeBody().get(i).getxPos().equals(snake.getSnakeBody().get(0).getxPos())) && (snake.getSnakeBody().get(i).getyPos().equals(snake.getSnakeBody().get(0).getyPos()))) {
                return true;
            }
        }
        return false;
    }

    public void generateApple() {
        setObjectPosition(fruit, new Position(fruit.getRandomX(), fruit.getRandomY()));
    }

}
