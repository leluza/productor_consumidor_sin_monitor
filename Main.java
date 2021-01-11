public class Main {

    public static void main(String[] args) {

        // crea un EventStorage
        EventStorage storage = new EventStorage();

        // crea diez producers y threads para correrlos
        Producer producer1 = new Producer(storage);
        Thread thread1 = new Thread(producer1);
        Producer producer2 = new Producer(storage);
        Thread thread2 = new Thread(producer2);
        Producer producer3 = new Producer(storage);
        Thread thread3 = new Thread(producer3);
        Producer producer4 = new Producer(storage);
        Thread thread4 = new Thread(producer4);
        Producer producer5 = new Producer(storage);
        Thread thread5 = new Thread(producer5);
        Producer producer6 = new Producer(storage);
        Thread thread6 = new Thread(producer6);

        // crea dos consumers y threads para correrlos
        Consumer consumer1 = new Consumer(storage);
        Thread thread7 = new Thread(consumer1);
        Consumer consumer2 = new Consumer(storage);
        Thread thread8 = new Thread(consumer2);

        // crea el log
        Log log = new Log(storage, consumer1, consumer2);
        Thread thread9 = new Thread(log);

        // inicializa los threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();

        // espera a los demas hilos
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // mata al log
        thread9.interrupt();
    }
}
