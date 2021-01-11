public class Producer implements Runnable {

    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    public void run() {
        // agrega items al buffer
        
        for (int i=0; i<50; i++) 
            storage.set();
    }
}
