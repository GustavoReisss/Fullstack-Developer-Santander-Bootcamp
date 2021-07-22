import java.util.function.Consumer;

public class Consumidores {
    
    public static void main(String[] args) {
        Consumer<String> imprimeUmaFrase = System.out::println; // O metodo entende que por baixo dos panos ele está recebendo um parâmetro para o sysout
        Consumer<String> imprimeUmaFrase2 = frase -> System.out.println(frase); // aqui o parâmetro está especificado

        imprimeUmaFrase.accept("Hello World");
        imprimeUmaFrase2.accept("Hello World 2");
    }
}
