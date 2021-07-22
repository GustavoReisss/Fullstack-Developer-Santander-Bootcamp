import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ExamploList {

    public static void main(String[] args) {
        
        List<String> nomes = new ArrayList<>(); // criação da lista

        // adição dos elementos
        nomes.add("Carlos");
        nomes.add("Pedro");
        nomes.add("Anderson");
        nomes.add("Juliana");
        nomes.add("Maria");
        nomes.add("João");
        System.out.println(nomes); // mostrando a lista
        
        System.out.println("==============================================");
        
        for(String nomeDoItem : nomes) { // ForEach -> pra cada elemento da lista nomes...
            System.out.println("Elemento da lista com For Each: " + nomeDoItem);
        }
        
        System.out.println("==============================================");


        Iterator<String> iterator = nomes.iterator(); // Instanciando um iterator para lista nomes
        
        while(iterator.hasNext()) { // retorna um boolean true se existir um proximo elemento na lista

            System.out.println("Elemento da lista com o Iterator: " + iterator.next()); // retorna o objeto que será iterado
            
        }

        System.out.println("==============================================");

        nomes.set(2, "Larissa");
        System.out.println(nomes); // mundando "Anderson" por "Larissa"

        Collections.sort(nomes);  // ordenando e ordem alfabética
        System.out.println(nomes); // lista ordenada

        nomes.set(2, "Wesley"); // mudando uma posição com a lista ordenada
        System.out.println(nomes);

        nomes.remove(4); // remove o elemento na posição 4
        System.out.println(nomes);

        nomes.remove("Wesley"); // removendo informando o objeto
        System.out.println(nomes);

        String nome = nomes.get(1); // retorna o elemento na posição 1 da lista
        System.out.println("Nome da posição [1]: " + nome); //printa o elemento retornado

        int posicao = nomes.indexOf("Carlos"); // retorna a posicao de um elemento da lista
        System.out.println("Posição de Carlos na lista: " + posicao);

        int tamanho = nomes.size(); // tamanho da lista
        System.out.println("Tamanho da lista: " + tamanho); 

        boolean temLarissa = nomes.contains("Larissa"); // Método que verifica se a lista contem o objeto informado. 
        System.out.println("Existe Larissa na lista? - " + temLarissa);

        boolean temFernando = nomes.contains("Fernando");
        System.out.println("Existe Fernando na lista? - " + temFernando);

        boolean listaEstaVazia = nomes.isEmpty(); // método que verifica se a lista está vazia
        System.out.println("Lista está vazia? - " + listaEstaVazia);
        
        nomes.clear(); // esvazia a lista
        listaEstaVazia = nomes.isEmpty();
        System.out.println("Lista está vazia? - " + listaEstaVazia);

    }
}