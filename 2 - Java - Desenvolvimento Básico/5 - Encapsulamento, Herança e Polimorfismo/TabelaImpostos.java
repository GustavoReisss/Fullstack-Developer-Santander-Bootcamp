// Calcular imposto dos funcionarios:
// Gerente paga 0.1%
// Supervisor paga 0.05%
// Atendente paga 0.01%

public class TabelaImpostos {
    
    public static void main(String[] args) {
        Gerente gerente = new Gerente(1000);
        Supervisor supervisor = new Supervisor(1000);
        Atendente atendente = new Atendente(1000);

        System.out.println("imposto do gerente: " + gerente.calculaImposto());  // 100.0
        System.out.println("imposto do supervisor: " + supervisor.calculaImposto());  // 50.0
        System.out.println("imposto do atendente: " + atendente.calculaImposto());  // 10.0
    }
}
