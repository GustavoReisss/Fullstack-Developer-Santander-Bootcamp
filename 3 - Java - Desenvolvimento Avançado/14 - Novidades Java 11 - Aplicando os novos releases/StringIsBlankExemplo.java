// como saber se uma String está vazia

public class StringIsBlankExemplo {
    
    public static void main(String[] args) {
        
        String espaco = "                                 ";
        

        // método antigo
        System.out.println(espaco == null || espaco.length() == 0 || espaco.chars().allMatch( c -> c == ' '));
    
        
        // método pós java 11
        System.out.println(espaco.isBlank());
    }

}
