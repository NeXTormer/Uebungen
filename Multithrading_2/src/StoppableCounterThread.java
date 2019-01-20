public class StoppableCounterThread extends Thread
{

    private int count = 0;

    public StoppableCounterThread()
    {
        super();
    }


    @Override
    public void run()
    {
        while(!isInterrupted() && isAlive())
        {
            count++;
            System.out.println(count);
            ThreadUtil.sleep(50);
        }
    }

}
