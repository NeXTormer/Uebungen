public class CounterThread extends Thread implements Runnable
{

    private String name;

    public CounterThread(String name)
    {
        super();
        this.name = name;


    }

    public void run()
    {
        for(int i = 0; i < 20; i++)
        {
            System.out.println(name + ": " + i + " ");
            //ThreadUtil.sleepRandom(500);
        }

    }


}
