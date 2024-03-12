package ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author eduardo
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número maior que 5000: ");
        int limite = scanner.nextInt();

        if (limite <= 5000) {
            System.out.println("Por favor, digite um número maior que 5000.");
            return;
        }
        System.out.println("Informe o numero de contadores: ");
        int cont = scanner.nextInt();
        List<Contador> contadores = new ArrayList<>();
        for (int i = 0; i < cont; i++) {
            Contador contador = new Contador(i, limite);
            contadores.add(contador);
        }
        for (Contador contador : contadores) {
            contador.start();
        }
        scanner.close();
    }
}
