import java.util.function.UnaryOperator;

public class Funcional {
    
    public static void main(String[] args) {
        UnaryOperator<Integer> calcularValorVezesTrinta = valor -> valor * 3;

        System.out.println("O resultado é: " + calcularValorVezesTrinta.apply(10));
    }
}
