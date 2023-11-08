
package actividadhilos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor implements Runnable{
    private Buffer buffer;
    private Random random;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.getSumaTotal() <= 100) {
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            buffer.consume();
        }
    }
}
