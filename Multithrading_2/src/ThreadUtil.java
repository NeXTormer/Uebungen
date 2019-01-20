public class ThreadUtil
{
    public static void sleepRandom(int maxms)
    {
        try {
            Thread.sleep((long) (Math.random() * maxms));
        } catch (InterruptedException e) {
            System.err.println("Sleep interrupted");
            Thread.currentThread().interrupt();
        }
    }

    public static void sleep(int ms)
    {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.println("Sleep interrupted");
            Thread.currentThread().interrupt();
        }
    }


}
