package actividadhilos;

public class Buffer {

    private int[] buffer;
    // Capacidad máxima del array.
    private static int MAX_BUFFER;
    // Posición del array.
    private int index = 0;
    // Suma de los valores.
    private int sumaTotal;
    // Suma máxima para acabar el programa.
    private static int MAX_NUMBER;

    // Valor de las variables estáticas.
    static {
        MAX_BUFFER = 10;
        MAX_NUMBER = 100;
    }

    // Crea el array con el número indicado.
    public Buffer() {
        buffer = new int[MAX_BUFFER];
    }

    // Produce valores y los suma mientras haya números en el array y no se llegue al valor máximo indicado.
    public synchronized void producir(int valor, int idProductor) throws InterruptedException {

        while (buffer.length == index) {
            wait();
        }
        buffer[index] = valor;
        index++;
        System.out.println("El hilo productor " + idProductor + " introduce el valor " + valor + " en la posición " + index);

        if (sumaTotal >= MAX_NUMBER) {
            System.out.println("Se ha llegado al valor máximo: " + sumaTotal);
            System.exit(0);
        }
        notifyAll();
    }

    public synchronized int consume() {
        if (index == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int valor = buffer[index - 1];
        sumaTotal += valor;
        index--;
        System.out.println("El hilo consumidor saca el valor " + valor + " de la posición " + (index+1));

        notifyAll();
        return valor;

    }

    public int getSumaTotal() {
        return sumaTotal;
    }
}
