package guiApp.windowParts;

import guiApp.MainWindow;
import guiApp.windowParts.areas.GameControlArea;
import guiApp.windowParts.areas.GameInfoArea;
import guiApp.windowParts.areas.PlayerControlArea;
import guiApp.windowParts.areas.PlayerInfoArea;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 28.04.2022
 */

public class InfoPanel extends JPanel {

    private GameControlArea gameControlArea;
    private GameInfoArea gameInfoArea;
    private PlayerInfoArea playerInfoArea;
    private PlayerControlArea playerControlArea;

    private JTextArea logs;
    private JScrollPane scrollBox;

    private MainWindow mainWindow;

    public InfoPanel(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setLayout(new GridLayout(5, 1));

        createParts();
        createLogArea();


        add(gameControlArea);
        add(gameInfoArea);
        add(playerInfoArea);
        add(playerControlArea);
        add(scrollBox);
    }

    private void createParts() {
        gameControlArea = new GameControlArea(this);
        gameInfoArea = new GameInfoArea(this);
        playerInfoArea = new PlayerInfoArea();
        playerControlArea = new PlayerControlArea(this);
    }

    private void createLogArea() {
        logs = new JTextArea();
        logs.setEditable(false);
        logs.setLineWrap(true);
        scrollBox = new JScrollPane(logs);
    }

    public void launchGame() {
        mainWindow.launchGame();
    }

    public void recordLog(String msg) {
        logs.append(msg + "\n");
    }

    public void refreshInfo(GameMap map) {
        gameInfoArea.refreshFields(map.getSizeMap(), map.getLevelCount(), map.getCountEnemies());
        playerInfoArea.refreshFields(map.getPlayer());
    }

    public void updatePlayer(int key) {
        mainWindow.updatePlayer(key);
    }
}
