import java.util.Arrays;

public class ParVezes2Funcional {
    
    public static void main(String[] args) {
        int[] valores = {1, 2, 3, 4};

        Arrays.stream(valores)
                .filter(numero -> numero % 2 == 0) // Filtra os números pares
                .map(numero -> numero * 2)  // Usa os números filtrados e os multiplica por 2
                .forEach(numero -> System.out.println(numero));  // imprime os números pares multiplicados por 2
    }
}
