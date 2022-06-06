package guiApp.models;

import guiApp.Tools;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 12.05.2022
 */

public class Enemy {

    private int count;

    private int health;
    private int power;
    private int valueMin = 5;
    private int valueMax = 10;
    private int x;
    private int y;

    public Enemy(int count) {
        this.health = Tools.randomValue(valueMin, valueMax);
        this.power = Tools.randomValue(valueMin, valueMax);
        this.count = count;
    }

    public int getPower() {
        return power;
    }

    public int getHealth() {
        return health;
    }

    public boolean isEnemyExist() {
        return count > 0;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void decreaseEnemyCount() {
        --count;
    }

    public int getCount() {
        return count;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
