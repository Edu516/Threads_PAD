package ex3;

/**
 *
 * @author eduardo
 */
public class Main {


    public static void main(String[] args) {
        Semaforo semaforo1 = new Semaforo("Semaforo 1", 3000); // Tempo em milissegundos
        Semaforo semaforo2 = new Semaforo("Semaforo 2", 3000);
        Semaforo semaforo3 = new Semaforo("Semaforo 3", 3000);
        Semaforo semaforo4 = new Semaforo("Semaforo 4", 3000);

        semaforo1.start();
        semaforo2.start();
        semaforo3.start();
        semaforo4.start();
    }
}
