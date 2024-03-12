package ex2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author eduardo
 */
public class Contador extends Thread {
    private int cod;
    private int limite;
    private Set<Integer> numeros = new HashSet<>();

    public Contador(int cod, int limite) {
        this.cod = cod;
        this.limite = limite;
    }

    public int getLimite() {
        return limite;
    }
    
    public void addNum(int num){
        numeros.add(num);
    }
    
    public boolean validaNum(int num){
        return numeros.contains(num);
    }

    @Override
    public void run() {
        int num = 0;
        int i = 1;
        while (num <= getLimite()) {
            int aleat = aleatorio();
            if(!validaNum(aleat)){
                num = num + aleat;
                System.out.println("| Contador : " + cod + " | Contagem " + num + " |"+"Aleatorio: "+aleat + " loop : " + i);
                Thread.yield();
                i++;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private int aleatorio() {
        int limiteInferior = 1;
        int limiteSuperior = getLimite(); 
        Random random = new Random();

        return random.nextInt(limiteSuperior - limiteInferior) + limiteInferior;
    }
}
