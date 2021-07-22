import java.util.function.BiPredicate;

public class FuncoesPuras {
    
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> verificarSeMaior =
            (parametro, valorComparacao) -> parametro > valorComparacao;

            System.out.println(verificarSeMaior.test(13, 12));
            System.out.println(verificarSeMaior.test(13, 12));

            System.out.println(verificarSeMaior.test(11, 14));
            System.out.println(verificarSeMaior.test(11, 14));

    }
}

// Funções puras devem sempre retornar o mesmo valor quando os parametros
// recebidos forem os mesmos