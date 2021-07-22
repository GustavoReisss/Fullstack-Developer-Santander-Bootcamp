package digital_innovation_one_core.src.digital_innovation_one_core;

import digital_innovation_one_utils.src.digital_innovation_one_utils.Calculadora;

public class Runner {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        System.out.println(calculadora.sum(5, 5));

    }
}
