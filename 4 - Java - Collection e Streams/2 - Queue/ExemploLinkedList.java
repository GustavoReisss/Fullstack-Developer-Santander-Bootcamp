import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ExemploLinkedList {

    public static void main(String[] args) {
        
        Queue<String> filaBanco = new LinkedList<>();

        filaBanco.add("Pamela");
        filaBanco.add("Patricia");
        filaBanco.add("Roberto");
        filaBanco.add("Flávio");
        filaBanco.add("Anderson");

        System.out.println(filaBanco);  // Mostra a fila
        
        System.out.println("\n.poll()\n");
        String clienteASerAtendido = filaBanco.poll(); // .poll() --> Retorna o primeiro elemento da fila e o remove.
        System.out.println(clienteASerAtendido);
        System.out.println(filaBanco);

        System.out.println("\n.peek()\n");
        String primeiroCliente = filaBanco.peek(); // .peek() --> Retorna o primeiro elemento da fila, mas não o remove,
        System.out.println(primeiroCliente);      // e  caso a fila esteja vazia o método irá retornar NULL.
        System.out.println(filaBanco);

        System.out.println(".element()\n");
        String primeiroClienteOuErro = filaBanco.element();   // .element() --> Retorna o primeiro elemento da lista e 
        System.out.println(primeiroClienteOuErro);            // não o remove, e caso a fila esteja vazia retorna uma excessão                                   
        System.out.println(filaBanco);
        
        System.out.println("\n==============================================");

        for (String cliente : filaBanco){
            System.out.println("Elementos da fila com o ForEach: " + cliente);
        }
 
        System.out.println("==============================================");
        
        Iterator<String> iteratorFilaBanco = filaBanco.iterator();
        while(iteratorFilaBanco.hasNext()){
            System.out.println("Elementos da fila com o Iterator: " + iteratorFilaBanco.next());
        }

        System.out.println("==============================================");

        int tamanhoFila = filaBanco.size();

        System.out.println("\nTamanho da fila: " + tamanhoFila + "\n");

        // excessão .element()
        System.out.println("\nexcessão .element() ::\n");
        filaBanco.clear(); // limpa a fila
        primeiroClienteOuErro = filaBanco.element();   
        System.out.println(primeiroClienteOuErro); 
        System.out.println(filaBanco);
        
    }
}