public class Supervisor extends Funcionarios {
    
    public Supervisor(double salario){
        setSalario(salario);
    }

    @Override
    public double calculaImposto() {
        return getSalario() * 0.05;
    }
}
