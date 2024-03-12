package ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author eduardo
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner entrada = new Scanner(System.in);
        List<Corredor> corredores =  new ArrayList<Corredor>();
        Corredor corredor;
        boolean inicia =  true;
        int competidores = 2;
        int distancia = 100;
        while(inicia){
            System.out.println("Informe o numero de corredores");
            System.out.println("Obs2: Não pode ser realizada com menos de 2 competidores");
            int num = entrada.nextInt();
            if(num >= 2){
                inicia = false;
                competidores = num;
            }
        }
        for (int i = 1; i <= competidores; i++) {
            Scanner ent = new Scanner(System.in);
            System.out.println("Informe o nome do Competidor: ");
            String nome = ent.nextLine();
            corredor = new Corredor(i,nome, distancia);
            corredores.add(corredor);
        }
        for (Corredor corre : corredores) {
            corre.start();
        }
    }
}
