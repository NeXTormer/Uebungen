public class CounterRunnable implements Runnable
{

    private String name;

    public CounterRunnable(String name)
    {
        this.name = name;
    }

    @Override
    public void run()
    {
        for(int i = 0; i < 20; i++)
        {
            System.out.println(name + ": " + i + " ");
            //ThreadUtil.sleepRandom(500);
        }
    }
}
