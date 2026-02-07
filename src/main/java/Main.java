import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);
    ArrayList<Double> numeros = new ArrayList<Double>();
    ArrayList<Double> numeros2 = new ArrayList<Double>();
    ArrayList<Double> soma = new ArrayList<Double>();
    int vaiUm = 0;
    System.out.println("Digite um número e aperte Enter.");
    System.out.println("Para encerrar e ver a soma, aperte Enter em uma linha vazia:");

    // primeira captura binario
    while (true) {
      String entrada = leitor.nextLine(); 

      // Se a entrada estiver vazia (apenas o Enter), sai do loop
      if (entrada.isEmpty()) {
        break;
      }

      try {
        // Converte o texto para número e adiciona na lista
        double n = Double.parseDouble(entrada.trim());
        numeros.add(n);
        System.out.println("Adicionado! Total de itens: " + numeros.size());
      } catch (NumberFormatException e) {
        System.out.println("Ops! Isso não parece um número. Tente novamente.");
      }
    }
    // segunda captura binario
    while (true) {
      String entrada = leitor.nextLine(); 

      // Se a entrada estiver vazia (apenas o Enter), sai do loop
      if (entrada.isEmpty()) {
        break;
      }

      try {
        // Converte o texto para número e adiciona na lista
        double n = Double.parseDouble(entrada.trim());
        numeros2.add(n);
        System.out.println("Adicionado! Total de itens: " + numeros2.size());
      } catch (NumberFormatException e) {
        System.out.println("Ops! Isso não parece um número. Tente novamente.");
      }
    }
    // igualando tamanho dos vetores e colocando zeros a esquerda
    if (numeros.size() > numeros2.size()) {
      int diferenca = numeros.size() - numeros2.size();
      for (int i = 0; i < diferenca; i++) {
        numeros2.add(0, 0.0);
      }
    }
    if (numeros2.size() > numeros.size()) {
      int diferenca2 = numeros2.size() - numeros.size();
      for (int i = 0; i < diferenca2; i++) {
        numeros.add(0, 0.0);
      }
    }
    // soma dos binarios
    // como eles vao ter o msm tamanho, posso usar o tamanho de um deles

    for (int i = numeros.size() - 1; i >= 0; i--) {
      double n1 = numeros.get(i);
      double n2 = numeros2.get(i);
      double resultado = n1 + n2 + vaiUm;
      if (resultado == 0) {
        soma.add(0, 0.0);
        vaiUm = 0;
      } else if (resultado == 1) {
        soma.add(0, 1.0);
        vaiUm = 0;
      } else if (resultado == 2) {
        soma.add(0, 0.0);
        vaiUm = 1;
      } else if (resultado == 3) {
        soma.add(0, 1.0);
        vaiUm = 1;
      }
    }

    if (vaiUm == 1) {
      soma.add(0, 1.0);
    }

    System.out.println("\n--- Resultado Final ---");
    System.out.println("Primeiro numero binario: " + numeros);
    System.out.println("Segundo numero binario: " + numeros2);
    System.out.println("Soma dos binarios: " + soma);

    leitor.close();
  }
}