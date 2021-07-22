import java.util.function.Function;

public class Funcoes {

    public static void main(String[] args) {
        Function<String, String> retornarNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
        System.out.println(retornarNomeAoContrario.apply("Gustavo"));
        
        Function<String, Integer> converterStringParaInteiroEDobrar = string -> { // poderia ser executado em apenas uma linha sem usar o return.
            System.out.println("Oi sou o número: " + string);
            return Integer.valueOf(string) * 2;
        };
        System.out.println(converterStringParaInteiroEDobrar.apply("322"));        
    }

}