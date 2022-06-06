package guiApp.windowParts;

import guiApp.MainWindow;
import guiApp.Tools;
import guiApp.models.Enemy;
import guiApp.models.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 28.04.2022
 */

public class GameMap extends JPanel {

    private int mapWidth;
    private int mapHeight;
    private int mapSizeMin = 2;
    private int mapSizeMax = 5;

    private int[][] map;
    private int[][] invisibleMap;

    private int emptyCell = 0;
    private int enemyCell = 1;
    private int playerCell = 2;
    private int coinsCell = 10;
    private int readyCell = 99;

    private int levelCount = 0;

    private boolean isGameReady;
    private boolean isGameOver;

    private int cellW;
    private int cellH;

    private Player player;
    private Enemy enemy;

    private MainWindow mainWindow;

    public GameMap(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setBackground(Color.BLACK);
        isGameReady = false;
    }

    public void launchGame() {
        player = new Player("Lancelot");
        levelCount = 0;
        levelCycle();
        mainWindow.refreshGameInfo(this);
        isGameOver = false;
    }

    private void levelCycle() {
        createMap();
        spawnPlayer();
        spawnEnemy();
        ++levelCount;
        repaint();
        mainWindow.recordLog("Start Level " + levelCount);
    }

    private void renderGame(Graphics g) {
        if (!isGameReady) {
            return;
        }

        paintMap(g);
        paintObject(g);

    }

    private void paintObject(Graphics g) {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {

                if (map[y][x] == emptyCell) {
                    continue;
                }

                if (map[y][x] == playerCell) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x * cellW + 5, y * cellH + 5, cellW - 10, cellH - 10);
                }

//                if (map[y][x] == enemyCell) {
//                    g.setColor(Color.RED);
//                    g.fillRect(x * cellW + 5, y * cellH + 5, cellW - 10, cellH - 10);
//                }

                if (map[y][x] == readyCell) {
                    g.setColor(Color.GRAY);
                    g.fillRect(x * cellW + 5, y * cellH + 5, cellW - 10, cellH - 10);
                }
            }
        }
    }

    private void paintMap(Graphics g) {
        int widthSelf = getWidth();
        int heightSelf = getHeight();

        cellW = widthSelf / mapWidth;
        cellH = heightSelf / mapHeight;

        g.setColor(Color.WHITE);

        for (int i = 0; i <= mapHeight; i++) {
            int y = i * cellH;
            g.drawLine(0, y, widthSelf, y);
        }

        for (int i = 0; i <= mapWidth; i++) {
            int x = i * cellW;
            g.drawLine(x, 0, x, heightSelf);
        }

    }

    public void updatePlayer(int key) {
        if (!isGameReady) {
            return;
        }

        if (isGameOver) {
            return;
        }

        int currentPlayerX = player.getX();
        int currentPlayerY = player.getY();

        switch (key) {
            case Player.MOVE_UP:
                player.moveUp();
                break;
            case Player.MOVE_DOWN:
                player.moveDown();
                break;
            case Player.MOVE_LEFT:
                player.moveLeft();
                break;
            case Player.MOVE_RIGHT:
                player.moveRight();
                break;
        }

        if (!isValidPlayerMove(currentPlayerX, currentPlayerY, player.getX(), player.getY())) {
            return;
        }

        playerNextCellAction(currentPlayerX, currentPlayerY, player.getX(), player.getY());
        mainWindow.refreshGameInfo(this);
        repaint();
    }

    private void createMap() {
        mapWidth = Tools.randomValue(mapSizeMin, mapSizeMax);
        mapHeight = Tools.randomValue(mapSizeMin, mapSizeMax);
        map = new int[mapHeight][mapWidth];
        invisibleMap = new int[mapHeight][mapWidth];

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                map[y][x] = emptyCell;
                invisibleMap[y][x] = emptyCell;
            }
        }
        isGameReady = true;
    }

    private void spawnPlayer() {
        player.setPosition(Tools.randomValue(0, mapWidth - 1), Tools.randomValue(0, mapHeight - 1));
        map[player.getY()][player.getX()] = playerCell;
    }

    private void spawnEnemy() {
        enemy = new Enemy(getFreeCells() / 2);

        for (int i = 1; i <= enemy.getCount(); i++) {

            do {
                enemy.setPosition(Tools.random.nextInt(mapWidth), Tools.random.nextInt(mapHeight));
            } while (!isCellClear(enemy.getX(), enemy.getY(), invisibleMap) || !isCellClear(enemy.getX(), enemy.getY(), map));
            invisibleMap[enemy.getY()][enemy.getX()] = enemyCell;
        }
    }

    public boolean isValidPlayerMove(int lastX, int lastY, int nextX, int nextY) {
        if (isCellValid(nextX, nextY)) {
            return true;
        } else {
            player.setPosition(lastX, lastY);
            return false;
        }
    }

    public void playerNextCellAction(int lastX, int lastY, int nextX, int nextY) {
        if (invisibleMap[nextY][nextX] == enemyCell) {
            player.decreaseHealth(enemy.getPower());
            enemy.decreaseEnemyCount();
            invisibleMap[nextY][nextX] = emptyCell;
            mainWindow.recordLog(player.getName() + " has been attack");
        }

        map[lastY][lastX] = readyCell;
        map[nextY][nextX] = playerCell;
        repaint();

        if (!player.isAlive()) {
            isGameOver = true;
            JOptionPane.showMessageDialog(this, player.getName() + " is dead. Game over");
        }

        if (!enemy.isEnemyExist()) {
            player.increaseExp(300 * levelCount);
            levelCycle();
        }
    }

    public boolean isCellClear(int x, int y, int[][] map) {
        return map[y][x] == emptyCell;
    }

    public boolean isCellValid(int x, int y) {
        return x >= 0 && x < mapWidth && y >= 0 && y < mapHeight;
    }

    public int getFreeCells() {
        int tmp = 0;
        for (int i = 0; i < invisibleMap.length; i++) {
            for (int j = 0; j < invisibleMap[i].length; j++) {
                if (invisibleMap[i][j] == emptyCell) {
                    tmp++;
                }
            }
        }
        return tmp - 1;
    }

    public String getSizeMap() {
        return mapWidth + "x" + mapHeight;
    }

    public int getLevelCount() {
        return levelCount;
    }

    public Player getPlayer() {
        return player;
    }

    public int getCountEnemies() {
        return enemy.getCount();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderGame(g);
    }
}
