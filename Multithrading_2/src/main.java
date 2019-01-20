public class main {

    public static void main(String[] args) {

        if(false)
        {
            CounterThread t1 = new CounterThread("werner");
            CounterThread t2 = new CounterThread("peter");
            CounterThread t3 = new CounterThread("lex");

            t1.start();
            t2.start();
            t3.start();


            Thread t4 = new Thread(new CounterRunnable("werner"));
            Thread t5 = new Thread(new CounterRunnable("peter"));
            Thread t6 = new Thread(new CounterRunnable("findenig"));

            t4.start();
            t5.start();
            t6.start();

            System.out.println("End of main thread.");

        }
        else if(false)
        {

            StoppableCounterThread t7 = new StoppableCounterThread();
            t7.start();

            ThreadUtil.sleep(1000);
            t7.interrupt();


        }
        else
        {
            LostUpdateRunnable r1 = new LostUpdateRunnable();
            Thread t1 = new Thread(r1);
            Thread t2 = new Thread(r1);
            Thread t3 = new Thread(r1);
            Thread t4 = new Thread(r1);
            Thread t5 = new Thread(r1);
            Thread t6 = new Thread(r1);
            Thread t7 = new Thread(r1);
            Thread t8 = new Thread(r1);
            Thread t9 = new Thread(r1);

            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            t6.start();
            t7.start();
            t8.start();
            t9.start();
        }

    }
}
