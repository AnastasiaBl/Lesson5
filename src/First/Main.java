package First;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Threading blockingObject = new Threading();
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                synchronized (blockingObject) {
                    try {
                        blockingObject.wait();
                    } catch (InterruptedException e) {
                        System.out.println("The thread is interrupted");
                    }
                }
            }

        };
        Thread thread2= new Thread(thread1);
        System.out.println(thread2.getState());
        thread2.start();
        System.out.println(thread2.getState());
        try{
        Thread.sleep(3000);
        }catch(InterruptedException error){
            System.out.println("The thread is interrupted");
        }
        System.out.println(thread2.getState());
        synchronized (blockingObject) {
            blockingObject.notify();
        }
        System.out.println(thread2.getState());
        thread1.interrupt();
        Thread.sleep(2000);
        thread2.interrupt();
        System.out.println(thread2.getState());
    }
}



















