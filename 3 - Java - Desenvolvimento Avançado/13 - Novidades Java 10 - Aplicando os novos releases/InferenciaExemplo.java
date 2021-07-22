import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;


public class InferenciaExemplo {
    
    public static void main(String[] args){
        //printarNomeCompleto("joao", "Cleiton");
        
        //printarSoma(10, 5, 1, 9);

        connectAndPrintURLJavaOracle();

    }

    public static void connectAndPrintURLJavaOracle(){        
        try {
            var url = new URL("https://docs.oracle.com/javase/10/language/");
            var urlConnection = url.openConnection();
            
            try (var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))){
                System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printarNomeCompleto(String nome, String sobrenome){
        var nomeCompleto = String.format("%s %s", nome, sobrenome);
        System.out.println(nomeCompleto);
    }

    public static void printarSoma(int... numeros){
        int soma;

        if(numeros.length > 0){
            soma = 0;
            for(var numero : numeros){
                soma += numero;
            }

            System.out.println("A soma é " + soma);
        }
    }

    // var:

    // Consegue:
    
    // variáveis locais inicializadas.
    // variável suporte o enhaced for -> (forEach -> ( : )).
    // variável suporte do for iterativo (for( ; ; )).
    // variavel try with resource


    // Não consegue:

    // não pode ser utilizado em nível de classe.
    // não pode ser utilizado como parâmetro.
    // não pode ser utilizado em variaveis locais não inicializas ( var nome;) -> erro
}
