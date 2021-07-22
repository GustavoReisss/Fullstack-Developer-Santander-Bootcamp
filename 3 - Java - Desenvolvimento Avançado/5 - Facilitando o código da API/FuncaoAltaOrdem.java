public class FuncaoAltaOrdem {
    public static void main(String[] args) {
        Calculo soma = (a, b) -> a + b;
        Calculo subtracao = (a, b) -> a - b;
        Calculo divisao = (a, b) -> a / b;
        Calculo multiplicacao = (a, b) -> a * b;
        Calculo resto = (a, b) -> a % b;

        System.out.println(executarOperacao(soma, 1, 3)); //4
        System.out.println(executarOperacao(subtracao, 2, 4)); // -2
        System.out.println(executarOperacao(divisao, 15, 5)); // 3
        System.out.println(executarOperacao(multiplicacao, 4, 6)); // 24
        System.out.println(executarOperacao(resto, 10, 7)); // 3
    }

    public static int executarOperacao(Calculo calculo, int a, int b){ // função de alta ordem, recebe uma função como 
       return calculo.calcular(a, b);                                  // parametro ou retorna uma função como parametro.
    }
}

@FunctionalInterface
interface Calculo {
    public int calcular(int a, int b);
}

// O código acima executa a mesma função que o código abaixo, porém o de cima 
// está utilizando os padrões do método Funcional
//
// public static int somar(int a, b){
//    return a + b;
// }
