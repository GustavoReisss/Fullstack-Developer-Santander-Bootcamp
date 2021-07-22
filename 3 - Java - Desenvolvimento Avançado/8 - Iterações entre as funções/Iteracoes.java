import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {
    
    public static void main(String[] args) {
        // String[] nomes = {"Ana", "Bruno", "Bruno", "Cleiton", "Felipe", "Guilherme"};
        // Integer[] numeros = {2, 3, 5, 7, 8, 12, 18};

        // imprimirNomesFiltrados(nomes, "Bruno");

        // imprimirTodosOsNomes(nomes);

        // imprimirODobroDeCadaItemParDaLista(numeros);

        
        List<String> profissoes = new ArrayList<>();
        profissoes.add("Desenvolvedor");
        profissoes.add("Testador");
        profissoes.add("Gerente de projeto");
        profissoes.add("Gerente de qualidade");

        profissoes.stream()
            .filter(profissao -> profissao.startsWith("Gerente"))
            .forEach(System.out::println);
    }

    public static void imprimirNomesFiltrados(String[] nomes, String filtro){
        String nomesParaImprimir = "";

        for(int i = 0; i < nomes.length; i++){
            if (nomes[i].equals(filtro)){
                nomesParaImprimir += nomes[i] + " ";
            }
        }

        if(nomesParaImprimir.isEmpty()){
            nomesParaImprimir = "nome não encontrado.";
        }

        System.out.println("Nomes do for: " + nomesParaImprimir);


        String nomesParaImprimirDaStream = Stream.of(nomes)
            .filter(nome -> nome.equals(filtro))
            .collect(Collectors.joining());
        
        if(nomesParaImprimirDaStream.isEmpty()){
            nomesParaImprimir = "nome não encontrado.";
        }

        System.out.println("Nomes da Stream: " + nomesParaImprimirDaStream);
    }

    public static void imprimirTodosOsNomes(String... nomes){ // ou (String[] nomes)
        
        System.out.println("\nFor: \n");
        
        for(String nome : nomes){
            System.out.println(nome);
        }

        System.out.println("\nStream: \n");

        Stream.of(nomes) // recebe um array de nomes
            .forEach(System.out::println);  // para cada nome imprima nome
    }

    public static void imprimirODobroDeCadaItemParDaLista(Integer... numeros){ // ou (Integer[] numeros)
        
        System.out.println("\nFor: \n");

        for(Integer numero: numeros) {
            if(numero % 2 == 0){
                System.out.println("numero " + numero + " x 2: " + numero*2);
            }
        }

        System.out.println("\nStream: \n");

        // Stream.of(numeros)
        //    .filter(numero -> numero % 2 == 0)
        //    .forEach(numero -> System.out.println("numero " + numero + " x 2: " + numero*2));
        
        Stream.of(numeros)
            .filter(numero -> numero % 2 == 0)
            .map(numero -> numero * 2)
            .forEach(System.out::println);
    }
}
