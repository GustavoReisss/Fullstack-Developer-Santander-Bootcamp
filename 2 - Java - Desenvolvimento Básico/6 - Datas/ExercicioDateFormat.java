import java.text.SimpleDateFormat;
import java.util.Date;

//Converta a Data atual no formato DD/MM/YYYY HH:MM:SS:MMM


public class ExercicioDateFormat {
    public static void main(String[] args) {
        Date momento = new Date();
        SimpleDateFormat formatoDesejado = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
        String dataAtual = formatoDesejado.format(momento);

        System.out.println(dataAtual);
    }
}
