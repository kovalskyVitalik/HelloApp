package guiApp.models;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 12.05.2022
 */

public class Player {

    private String name;
    private int health;
    private int power;
    private int coins;
    private int exp;
    private int x;
    private int y;

    public static final int MOVE_UP = 8;
    public static final int MOVE_DOWN = 2;
    public static final int MOVE_LEFT = 4;
    public static final int MOVE_RIGHT = 6;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.power = 10;
        this.exp = 0;
        this.coins = 0;
    }

    public void moveUp() {
        y -= 1;
    }

    public void moveDown() {
        y += 1;
    }

    public void moveLeft() {
        x -= 1;
    }

    public void moveRight() {
        x += 1;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void decreaseHealth(int value) {
        health -= value;
    }

    public void increaseExp(int value) {
        exp += value;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getPosition() {
        return (x + 1) + ":" + (y + 1);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getPower() {
        return power;
    }

    public int getCoins() {
        return coins;
    }

    public int getExp() {
        return exp;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
