package ex3;

/**
 *
 * @author eduardo
 */
public class Semaforo extends Thread {
    private String nome;
    private boolean aberto;
    private int tempoEspera;
    private static Object lock = new Object(); // Objeto usado como lock para controle de sincronização
    private static Semaforo semaforoAbertoAtual; // Referência ao semáforo atualmente aberto

    public Semaforo(String nome, int tempoEspera) {
        this.nome = nome;
        this.aberto = false; // Inicia como fechado
        this.tempoEspera = tempoEspera;
    }

    public void run() {
        while (true) {
            exibirStatus();

            try {
                Thread.sleep(tempoEspera); // Aguarda o tempo definido antes de mudar o estado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            trocarEstado();
        }
    }

    private void trocarEstado() {
        synchronized (lock) {
            if (semaforoAbertoAtual == null || semaforoAbertoAtual == this) {
                aberto = !aberto; // Inverte o estado entre aberto e fechado
                semaforoAbertoAtual = aberto ? this : null; // Atualiza a referência ao semáforo atualmente aberto
            }
        }
    }

    private void exibirStatus() {
        System.out.println(nome + ": " + (aberto ? "Aberto" : "Fechado"));
    }
}
