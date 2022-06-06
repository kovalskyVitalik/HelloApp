package guiApp;

import guiApp.windowParts.GameMap;
import guiApp.windowParts.InfoPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 28.04.2022
 */

public class MainWindow extends JFrame {

    private int posX = 300;
    private int posY = 200;

    private int widthW = 1024;
    private int heightW = 768;

    private GameMap gameMap;
    private InfoPanel infoPanel;

    public MainWindow() {
        setupWindow();

        gameMap = new GameMap(this);
        infoPanel = new InfoPanel(this);

        add(gameMap);
        add(infoPanel, BorderLayout.EAST);

        setVisible(true);
    }

    private void setupWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(widthW, heightW);
        setLocation(posX, posY);
        setResizable(true);
        setTitle("First GUI-App");

    }

    public void launchGame() {
        gameMap.launchGame();
    }

    public void refreshGameInfo(GameMap map) {
        infoPanel.refreshInfo(map);
    }

    public void recordLog(String msg) {
        infoPanel.recordLog(msg);
    }

    public void updatePlayer(int key) {
        gameMap.updatePlayer(key);
    }
}
