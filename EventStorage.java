import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class EventStorage {

    private int maxSize;                    // tamaño maximo buffer
    private Queue<Date> storage;            // buffer
    private int c;                          // contador de eventos (no necesario)
    private Random rand;                    // generador random
    

    public EventStorage() {
        this.maxSize = 10;
        this.storage = new LinkedList<>();
        this.rand = new Random();
        this.c = 0;
    }

    public int getEventsCounter() {
        return c;
    }

    public int getStorageSize() {
        return storage.size();
    }

    public synchronized void set() {
        // si el buffer está lleno, se descarta objeto
        // de lo contrario, el producer agregará un objeto al buffer
        // habrá un retardo de "retard" milisegundos para agregar
          
        c++;
        String name = Thread.currentThread().getName();

        if(storage.size() == maxSize) {
            System.out.println(c + " - " + name + " - Set - FULL buffer");
        }
        else {
            storage.add(new Date());
            System.out.println(c + " - " + name + " - Set ");
            retard();
        }

        return;
    }

    public synchronized void get() {
        // si el buffer está vacio, el thread no hace nada
        // cuando no lo esté, el consumer quitará un objeto del buffer
        // habrá un retardo de "retard" milisegundos para quitar
         
        c++;
        String name = Thread.currentThread().getName();
        
        if(storage.size() == 0) {
            System.out.println(c + " - " + name + " - Get - EMPTY buffer");
        }
        else {
            String element = storage.poll().toString();
            System.out.println(c + " - " + name + " - Get: " + element);
            retard();
        }

        return;
    }

    public void retard() {
        // duerme al thread que lo ejecuta durante
        // un tiempo entre 30 y 200 milisegundos

        try {   
            long retard; 
            synchronized (this) {
                retard = (long) (30 + (rand.nextDouble() * 170));
            }                                                   
            Thread.sleep(retard);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return;
    }
}
