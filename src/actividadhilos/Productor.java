
package actividadhilos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor  implements Runnable{
    private Buffer buffer;
    private int producerId;


    public Productor(Buffer buffer, int par) {
        this.buffer = buffer;
        this.producerId = par;
        
    }

    @Override
    public void run() {
        while (true) {
            int value = (int) (Math.random() * 10) +1; 
            try {
                buffer.producir(value, producerId);
                Thread.sleep((int)(Math.random() * 2000 ));
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
