import java.io.BufferedWriter; 
import java.io.FileWriter;
import java.io.IOException; 
import java.util.concurrent.TimeUnit;

public class Log implements Runnable {

    private EventStorage storage;
    private Consumer consumer1, consumer2;

    public Log(EventStorage storage, Consumer consumer1, Consumer consumer2) {
        // constructor del log con referencias a ambos consumidores y al buffer

        this.storage = storage;
        this.consumer1 = consumer1;
        this.consumer2 = consumer2;
    }

    public void run() {
        // escribe en un archivo de texto el estado del buffer 
        // y de ambos consumidores cada dos segundos
        // dejará de escribir cuando no haya mas eventos (storage.getEventsCounter() = 600)

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("bufferStatistics.txt"));
            writer.write("--- BUFFER STATISTICS --- \n\n");
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        while(!Thread.currentThread().isInterrupted()) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("bufferStatistics.txt", true));
                writer.append("-> Buffer Size = " + storage.getStorageSize() + "\n");
                writer.append("-> Consumer 1 is busy : " + consumer1.getBusyFlag() + "\n");
                writer.append("-> Consumer 2 is busy : " + consumer2.getBusyFlag() + "\n\n");
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            
            try {                                                  
                TimeUnit.SECONDS.sleep(2);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\n -- VER bufferStatistics.txt --");
    }
}
