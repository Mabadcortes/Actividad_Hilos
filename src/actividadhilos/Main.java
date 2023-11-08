
package actividadhilos;

/**
 *
 * @author Usuario
 */
public class Main {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Thread p1 = new Thread(new Productor(buffer, 1));
        Thread p2 = new Thread(new Productor(buffer, 2));
        Thread c = new Thread(new Consumidor(buffer));

        p1.start();
        p2.start();
        c.start();
    }
    
}
