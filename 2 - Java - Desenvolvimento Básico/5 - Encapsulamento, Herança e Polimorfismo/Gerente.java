public class Gerente extends Funcionarios{
    
    public Gerente (double salario){
        setSalario(salario);
    }

    @Override
    public double calculaImposto() {
        return getSalario() * 0.1;
    }
}
