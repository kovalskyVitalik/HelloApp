package guiApp;

import java.util.Random;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 12.05.2022
 */

public class Tools {

    public static Random random = new Random();

    public static int randomValue(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

}
