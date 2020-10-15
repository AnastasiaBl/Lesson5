import java.util.ArrayList;
import java.util.Random;

public class ProducerConsumer<Wardrobe> {
    private static final int maxSize = 5;
    private final ArrayList<Wardrobe> lst = new ArrayList<>();
    Random random = new Random();


    synchronized void produce(Wardrobe value) throws InterruptedException {
        while (lst.size() == maxSize) {
            wait();
        }
        System.out.println("Producer produced "+value);
        lst.add(value);
        notify();
        Thread.sleep(500);
    }
    synchronized void consume() throws InterruptedException{
        while(lst.size() == 0 ){
            wait();
        }
        Wardrobe result = lst.remove(0);
        System.out.println("Consumer consumed "+result);
        notify();
        Thread.sleep(random.nextInt(1000));
    }
}
