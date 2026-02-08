import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);
    ArrayList<Double> numeros = new ArrayList<Double>();
    ArrayList<Double> numeros2 = new ArrayList<Double>();
    ArrayList<Double> soma = new ArrayList<Double>();
    
    // serve para fazer matriz 
    ArrayList<ArrayList<Double>> estanderesultados = new ArrayList<ArrayList<Double>>();
    ArrayList<Double> resultadoFinal = new ArrayList<Double>();
    
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
    double cont = 0;
    //11001
    // transformando os vetores binarios em numeros inteiros
    for(int i = numeros.size() -1; i >= 0 ; i--){
      double m1 = numeros.get(i);
      int inter= (numeros.size()-1) - i;
      
      cont += m1 * Math.pow(2,inter);
      
    }
    double cont2 = 0;
    for(int i = numeros2.size() -1; i >= 0 ; i--){
      double m1 = numeros2.get(i);
      int inter= (numeros2.size()-1) - i;

      cont2 += m1 * Math.pow(2,inter);

    }
    double cont3= 0;
    for(int i = soma.size() -1; i >= 0 ; i--){
      double m1 = soma.get(i);
      int inter= (soma.size()-1) - i;

      cont3 += m1 * Math.pow(2,inter);

    }
   

   // multiplicação de numeros binarios
    for(int i = numeros2.size() -1; i >= 0 ; i--){
      ArrayList<Double> linhaAtual = new ArrayList<Double>();
      double bitMult =  numeros2.get(i);

      int desloc= ((numeros2.size()-1)- i);
       //  o deslocamento feito na mutliplicação
      
      for(int d = 0 ; d< desloc ; d++){
        linhaAtual.add(0.0) ;
      }
      for (int j = numeros.size() - 1; j >= 0; j--) {
          double bitMultiplicado = numeros.get(j);
          linhaAtual.add(0, bitMultiplicado * bitMult); 
      }
      estanderesultados.add(linhaAtual);
    }

    for(int i = 0; i<estanderesultados.size(); i++){
      ArrayList<Double> proximaLinha = estanderesultados.get(i);

      // 3. Igualamos os tamanhos antes de somar
      // (A proximaLinha sempre será maior ou igual ao resultadoFinal)
      while (resultadoFinal.size() < proximaLinha.size()) {
          resultadoFinal.add(0, 0.0); // Adiciona zeros à esquerda
      }
      while (proximaLinha.size() < resultadoFinal.size()) {
          proximaLinha.add(0, 0.0);
      }
      ArrayList<Double> somaTemporaria = new ArrayList<Double>();
         vaiUm = 0;

      for (int j = resultadoFinal.size() - 1; j >= 0; j--) {
          double r = resultadoFinal.get(j) + proximaLinha.get(j) + vaiUm;
          if (r == 0) { somaTemporaria.add(0, 0.0); vaiUm = 0; }
          else if (r == 1) { somaTemporaria.add(0, 1.0); vaiUm = 0; }
          else if (r == 2) { somaTemporaria.add(0, 0.0); vaiUm = 1; }
          else if (r == 3) { somaTemporaria.add(0, 1.0); vaiUm = 1; }
      }

      if (vaiUm == 1) somaTemporaria.add(0, 1.0);

      // 5. Atualizamos o resultadoFinal com o que acabamos de somar
      resultadoFinal = somaTemporaria;
    }
    

    System.out.println("\n--- Resultado Final ---");
    
    System.out.println("Primeiro numero binario em decimal: " + cont);
    System.out.println("Segundo numero binario em decimal: " + cont2);
    System.out.println("A soma do numero binario em decimal: " + cont3);
    System.out.println("A multiplicação do numero binario em decimal: " + cont*cont2);
    System.out.println("Primeiro numero binario: " + numeros);
    System.out.println("Segundo numero binario: " + numeros2);
    System.out.println("Soma dos binarios: " + soma);
    System.out.println("Multiplicação dos binarios"+resultadoFinal);

    leitor.close();
  }
}