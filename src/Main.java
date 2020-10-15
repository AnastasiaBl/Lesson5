import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ProducerConsumer<Wardrobe> proc = new ProducerConsumer<>();
        Thread t1 = new Thread() {
            @Override
            public void run()
            {
                try {
                    while(!isInterrupted()){
                        Wardrobe myWardrobe = new Wardrobe.Builder()
                                .withSections((int)(Math.random() * 11))
                                .withHeight(Math.random()*20)
                                .withColor("Pink")
                                .build();

                        proc.produce(myWardrobe);
                        if(isInterrupted()) {
                            break;
                        }

                    }

                }
                catch (InterruptedException e) {
                    System.out.println("Producer interrupted");
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run()
            {
                try {
                    while (!isInterrupted()) {
                        proc.consume();
                        if(isInterrupted()) {
                            break;
                        }
                    }
                }

                catch (InterruptedException e) {
                    System.out.println("Consumer is interrupted");

                }
            }
        };

        t1.start();
        t2.start();

        //try {
          //  t1.join();
        //} catch (InterruptedException e) {
          //  e.printStackTrace();
        //}
        //try {
          //  t2.join();
        //} catch (InterruptedException e) {
          //  e.printStackTrace();
        //}
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();
        t2.interrupt();
    }
}

