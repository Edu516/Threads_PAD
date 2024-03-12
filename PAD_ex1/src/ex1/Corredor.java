package ex1;

import java.util.Random;

/**
 *
 * @author eduardo
 */
public class Corredor extends Thread{
    private int cod;
    private String Nome;
    private int distancia;
    
    public Corredor(int cod, String Nome, int distancia) {
        this.cod = cod;
        this.Nome = Nome;
        this.distancia = distancia;
    }
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
    @Override
    public void run() {
        int dis = 0;
        int i = 1;
        while(dis < distancia){
            dis = aleatorio() + dis;
            System.out.println("|"+Nome + " | " + dis+"m |"+ "loop :"+i);
            Thread.currentThread();
            Thread.yield();
            i++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            
    }
    
    public int aleatorio(){
        Random random = new Random();
        return random.nextInt(10);
    }

    
}
