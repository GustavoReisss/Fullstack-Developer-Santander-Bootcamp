import java.time.LocalDateTime;

// Adicione 4 anos, 6 meses e 13 horas ao momento 15/05/2010 10:00:00

public class ExercicioLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime dia15deMaioDe2010 = LocalDateTime.of(2010, 5, 15, 10, 0, 0);
        LocalDateTime dia15deMaioDe2010NoFuturo;

        // Antes
        System.out.println(dia15deMaioDe2010);

        dia15deMaioDe2010NoFuturo = dia15deMaioDe2010.plusYears(4).plusMonths(6).plusHours(13);

        // Depois
        System.out.println(dia15deMaioDe2010NoFuturo);
    }
}
