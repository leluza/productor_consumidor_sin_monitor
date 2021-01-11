public class Consumer implements Runnable {

    private EventStorage storage;
    private boolean busy;

    public Consumer(EventStorage storage) {
        this.storage = storage;
        this.busy = false;
    }

    public Boolean getBusyFlag() {
        return this.busy;
    }

    public void run() {
        // consume items del buffer
        // mientras lo hace, pasa a estado ocupado (busy = true)

        for (int i=0; i<150; i++) {
            this.busy = true;
            storage.get();
            this.busy = false;
        }
    }
}
