package model.entities;

import java.util.Random;

public class Fruit {
    private Position fruitPos;
    private Integer limit;
    private static Random random  = new Random();

    public Fruit(int limit) {
        this.fruitPos = new Position(0, 0);
        this.limit = limit;
    }

    public Position getFruitPos() {
        return fruitPos;
    }

    public void setFruitPos(Position fruitPos) {
        this.fruitPos = fruitPos;
    }

    public Integer getRandomX(){
        return random.nextInt(limit);
    }

    public Integer getRandomY(){
        return random.nextInt(limit);
    }

}
