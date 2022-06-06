package guiApp.windowParts.areas;

import guiApp.windowParts.InfoPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 28.04.2022
 */

public class GameInfoArea extends JPanel {

    private String prefixEnemiesCount = "Enemies: ";
    private String prefixLevel = "Level: ";
    private String prefixSizeMap = "Size map: ";

    private JLabel sizeMap;
    private JLabel levelGame;
    private JLabel enemiesCount;

    private InfoPanel infoPanel;

    public GameInfoArea(InfoPanel infoPanel) {
        this.infoPanel = infoPanel;

        setLayout(new GridLayout(4,1));

        sizeMap = new JLabel(prefixSizeMap + "?x?");
        levelGame = new JLabel(prefixLevel + "?");
        enemiesCount = new JLabel(prefixEnemiesCount + "?");

        add(new JLabel("= Game Info =", SwingConstants.CENTER));
        add(sizeMap);
        add(levelGame);
        add(enemiesCount);
    }

    public void refreshFields(String sizeMapInfo, int countLevel, int countEnemies) {
        sizeMap.setText(prefixSizeMap + sizeMapInfo);
        levelGame.setText(prefixLevel + countLevel);
        enemiesCount.setText(prefixEnemiesCount + countEnemies);
    }
}
