package ex4;
/**
 *
 * @author eduardo
 */
import javax.swing.Timer;

public class Cronometro extends Thread {
    private int segundos;
    private Timer timer;
    private Runnable atualizador;

    public Cronometro(Runnable atualizador) {
        this.segundos = 0;
        this.timer = new Timer(1000, e -> incrementarSegundos()); 
        this.atualizador = atualizador;
    }

    public void run() {
        timer.start();
    }

    public void pausar() {
        timer.stop();
    }

    public void zerar() {
        segundos = 0;
        atualizador.run(); 
    }

    public int getSegundos() {
        return segundos;
    }

    private void incrementarSegundos() {
        segundos++;
        atualizador.run();
    }
}
