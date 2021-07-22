abstract class Funcionarios{
    private double salario;
    
    public void setSalario(double salario){
        this.salario = salario;
    }

    public double getSalario(){
        return this.salario;
    }
    
    public double calculaImposto(){
        return this.salario * 0.01;
    }
}