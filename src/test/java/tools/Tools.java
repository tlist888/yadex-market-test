package tools;

/**
 * Tools class for testing
 *
 */
public class Tools {

    public static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}