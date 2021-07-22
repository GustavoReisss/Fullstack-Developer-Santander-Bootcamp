public class StringRepeatExemplo {
    
    public static void main(String[] args) {
        
        // Printar uma string com 10 vezes a varivável nome concatenada.
        
        // Sem o repeat
        String nome = "Joao";
        String aux = "";

        for (int i = 0; i < 10; i++) {
            aux+=nome;
        }

        System.out.println(aux);


        //com o repeat
        String nome2 = "Joao";
        System.out.println(nome2.repeat(10));
    }
}
