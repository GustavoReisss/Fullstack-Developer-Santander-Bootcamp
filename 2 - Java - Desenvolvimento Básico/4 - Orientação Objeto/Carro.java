public class Carro {
    private int capacidadePessoas;
    private int qtdPassageiros;

    public Carro(){
        this.capacidadePessoas = 5;
    }

    public Carro(int capacidadePessoas){
        this.capacidadePessoas = capacidadePessoas;
    }

    public int getCapacidadePessoas(){
        return this.capacidadePessoas;
    }

    public int getQtdPassageiros(){
        return this.qtdPassageiros;
    }

    public void setCapacidadePessoas(int capacidadePessoas){
        this.capacidadePessoas = capacidadePessoas;
    }

    public void setQtdPassageiros(int qtdPassageiros){
        if(qtdPassageiros <= capacidadePessoas || qtdPassageiros >= 0){
            this.qtdPassageiros = qtdPassageiros;
        }
    }

    public String adicionaPassageiro(){
        String resultado;

        if(getCapacidadePessoas() == getQtdPassageiros()){
            resultado = "Carro cheio!";
        } else {
            int qtdPassageiros = getQtdPassageiros();
            setQtdPassageiros(++qtdPassageiros);
            resultado = "Passageiro adicionado!";
        }
        return resultado;
    }

    public String removePassageiro(){
        String resultado;

        if(getQtdPassageiros() == 0){
            resultado = "O carro já está vazio!";
        }
        else{
            int qtdPassageiros = getQtdPassageiros();
            setQtdPassageiros(--qtdPassageiros);
            resultado = "Passageiro removido!";
        }
        return resultado;
    }

    @Override
    public String toString(){
        String carro = "O carro ";
        int qtdPassageiros = getQtdPassageiros();
        
        if(getCapacidadePessoas() == qtdPassageiros){
            carro += "possui " + qtdPassageiros + " e está cheio!";
        } else if(getQtdPassageiros() == 0){
            carro += "possui " + qtdPassageiros + " e está vazio!";
        } else {
            carro += "possui " + qtdPassageiros + " Passageiros";
        }
        return carro;
    }
}