// Parallel é recomendado quando há um enorme número de dados para serem processados.

import java.util.stream.IntStream;

public class ParallelStreamExemplo {
    
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        IntStream.range(1,100000).forEach(num -> fatorial(num)); // Serial
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de Execução Serial: " + (fim-inicio)); // 15055

        inicio = System.currentTimeMillis();
        IntStream.range(1,100000).parallel().forEach(num -> fatorial(num)); // Parallel
        fim = System.currentTimeMillis();
        System.out.println("Tempo de Execução Parallel: " + (fim-inicio)); //  8646
    }

    public static long fatorial(long num){
        long fat = 1;

        for(long i = 2; i <= num; i++){
            fat *= i;
        }

        return fat;
    }
}
