import java.util.function.Predicate;

public class Predicados {
    
    public static void main(String[] args) {
        Predicate<String> estaVazio = valor -> valor.isEmpty();

        System.out.println(estaVazio.test("")); // true
        System.out.println(estaVazio.test("Estou cheio"));  // false
    }
}
