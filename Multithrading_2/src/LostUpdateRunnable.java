public class LostUpdateRunnable implements Runnable
{

    public int counter = 0;


    private /* synchronized */ void increment()
    {
        int i = counter;
        counter = i + 1;
        System.out.println(counter);

    }

    public void run()
    {
        for(int i = 0; i < 1000000; i++)
        {
            increment();
        }

    }
}
